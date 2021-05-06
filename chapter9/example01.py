# 練習9-1 どのような機械学習手法を用いると良いか？
# 教師あり学習：分類

# 練習9-2 どのようなアウトプットを得られるか？また、その分析結果からどのようにスッキリ銀行の課題を解決する事が出来るか？
# ｙ列を予測する分類モデルを作ることにより、その顧客が購入してくれるかどうかが事前に分かる。
# また、特徴量にこちらからのアプローチ法を入れる事により、「この顧客の場合、こういうアプローチをとったら購入してくれる」というような営業の最適化を行う事が出来る

# 練習9-3
import pandas as pd
from sklearn import tree
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt

df = pd.read_csv('datafile/Bank.csv')
print(df.shape)
print(df.head())

str_col_name = ['job', 'default', 'marital', 'education', 'housing', 'loan', 'contact', 'month']
str_df = df[str_col_name]
str_df2 = pd.get_dummies(str_df, drop_first = True)
num_df = df.drop(str_col_name, axis = 1)
df2 = pd.concat([num_df, str_df2, str_df], axis = 1)
print(df2.columns)

train_val, test = train_test_split(df2, test_size = 0.1, random_state = 9)
print(train_val.head())

a = train_val.isnull().sum()
print(a[a > 0])
print(train_val['duration'].median())

train_val2 = train_val.fillna(train_val.median())
print(train_val2['y'].value_counts())

from sklearn.ensemble import RandomForestClassifier
t = train_val2['y']
x = train_val2.drop(str_col_name, axis = 1)
x = x.drop(['id', 'y', 'day'], axis = 1)

x_train, x_val, y_train, y_val = train_test_split(x, t, test_size = 0.2, random_state = 13)
model = tree.DecisionTreeClassifier(random_state = 3, max_depth = 3, class_weight = 'balanced')
#model = tree.DecisionTreeClassifier(random_state = 3, max_depth = 5)
print(model.fit(x_train, y_train))
print(model.score(x_val, y_val))

# 練習9-4
def learn(x,t,i):
    x_train,x_val,y_train,y_val = train_test_split(x,t,test_size=0.2,random_state=13)

    datas=[x_train,x_val,y_train,y_val]
    #不均衡データに対応できるように、class_weight引数も設定
    model = tree.DecisionTreeClassifier(random_state=i,max_depth=i,class_weight='balanced')
    model.fit(x_train,y_train)
    train_score=model.score(x_train,y_train)
    
    val_score=model.score(x_val,y_val)
    return train_score,val_score,model,datas

for i in range(1,20):
    s1,s2,model,datas = learn(x,t,i)
    print(i,s1,s2)

model = tree.DecisionTreeClassifier(max_depth = 11, random_state = 11)
model.fit(x, t)
test2 = test.copy()
test2 = test2.fillna(train_val.median())
test_y = test2['y']
test_x = test2.drop(str_col_name, axis = 1)
test_x = test_x.drop(['id', 'y', 'day'], axis = 1)
model.score(test_x, test_y)

a = pd.Series(model.feature_importances_, index = x.columns).sort_values(ascending = False)
print(a[0:9])


print(str_df.columns)

for name in str_df.columns:
    print(train_val.groupby(name)['y'].mean())
    print("next========")

print(pd.pivot_table(train_val, index="housing", columns="loan", values="duration"))
print(pd.pivot_table(train_val, index="housing", columns="contact", values="duration"))
print(pd.pivot_table(train_val, index="loan", columns="contact", values="duration"))

def nan_fill(train_val):
    isnull = train_val['duration'].isnull()

    #train_valを変えたくないので、py基本文法のcopyメソッドでコピーを作って
    #train_val2に代入
    train_val2 = train_val.copy()
    #housing=yesの処理
    train_val2.loc[(isnull) & (train_val2['housing']=='yes') 
                  &(train_val2['loan']=='yes'),'duration' ]=439
    train_val2.loc[(isnull) & (train_val2['housing']=='yes') 
                  &(train_val2['loan']=='no'),'duration' ]=332

    #housing=noの処理
    train_val2.loc[(isnull) & (train_val2['housing']=='no') 
                  &(train_val2['loan']=='yes'),'duration' ]=301
    train_val2.loc[(isnull) & (train_val2['housing']=='no') 
                  &(train_val2['loan']=='no'),'duration' ]=237
    
    return train_val2
train_val2=nan_fill(train_val)

train_val2.groupby('y')['duration'].median()
train_val2.groupby('y')['amount'].median()
train_val2.groupby('y')['campaign'].median()
train_val2.groupby('y')['age'].median()

t =train_val2['y']

x = train_val2.drop(str_col_name,axis=1)
x =x.drop(['id','y','day'],axis=1)
#x =train_val2[xcol]
for i in range(1,20):
    s1,s2,model,datas = learn(x,t,i)
    print(i,s1,s2)

s1,s2,model,datas = learn(x,t,10)

def syuukei(model,datas,flag=False):
    if flag:
        pre=model.predict(datas[0])
        y_val=datas[2]
    else:
        pre=model.predict(datas[1])
        y_val=datas[3]
    data={
        "pred":pre,
        "true":y_val
    }
    tmp=pd.DataFrame(data)
    return tmp,pd.pivot_table(tmp,index="true",columns="pred",values="true",aggfunc=len)
tmp,a=syuukei(model,datas,False)
print(a)

false=tmp.loc[(tmp['pred']==1)&(tmp['true']==0)].index
true=tmp.loc[(tmp['pred']==0)&(tmp['true']==0)].index
true_df=train_val2.loc[true]
false_df=train_val2.loc[false]
pd.concat([true_df.mean()["age":],false_df.mean()["age":]],axis=1).plot(kind="bar")
print(true)

from sklearn.preprocessing import StandardScaler

sc = StandardScaler()
tmp2=train_val2.drop(str_col_name,axis=1)
sc_data = sc.fit_transform(tmp2)
sc_df = pd.DataFrame(sc_data,columns=tmp2.columns,index=tmp2.index)

true_df=sc_df.loc[true]
false_df=sc_df.loc[false]
true_df
temp2=pd.concat([false_df.mean()["age":],true_df.mean()["age":]],axis=1)
temp2.plot(kind="bar")
plt.show()

#青色の０は誤分類、オレンジ１は正解のデータ
# durationと housing_yesが大きく異なる
#実際はy=0の人で、 durationが大きい人は誤分類しやすい
#実際はy=0の人で、 housingが大きい人は誤分類しやすい
#事前に、durationが大きい人はy=1になりやすいということは分かっているので、「こういう人はy=0になりやすい」という
#特徴量を見つけ出して、特徴量×durationという特徴量を作って、durationに重み付けをする列を作れば正解率
#があがるのではないか？ 続きは3部に譲ってここでテストデータ評価を行う

model_tree=tree.DecisionTreeClassifier(max_depth=10,random_state=10,class_weight="balanced")
model_tree.fit(x,t)

test2=nan_fill(test)
t =test2['y']
x = test2.drop(str_col_name,axis=1)
x =x.drop(['id','y','day'],axis=1)
print(model_tree.score(x,t))
