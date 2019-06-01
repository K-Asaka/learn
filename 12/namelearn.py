#! /usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
from sklearn.model_selection import train_test_split

np.random.seed(9)
# 男女のタグ付きひらがなの名前データを読み込む
txtbody = open('./12/names.txt', encoding='utf-8')
# NumPyのarrayに変換
jnames = np.array([x.split() for x in txtbody], dtype='U12')
# 名前と性別に分割
names_train, gender_train, = jnames[:, 1], jnames[:, 0]

def split_in_2words(name):
    return [name[i:i+2] for i in range(len(name) - 1)]

print(split_in_2words("とものり"))

from sklearn.feature_extraction.text import CountVectorizer
bow_t = CountVectorizer(analyzer=split_in_2words).fit(names_train)

name = 'かんかん'
b1 = bow_t.transform([name])
print(b1[0])

print(bow_t.get_feature_names()[283])
print(bow_t.get_feature_names()[1898])

names_bow = bow_t.transform(names_train)

from sklearn.feature_extraction.text import TfidfTransformer
tfidf_t = TfidfTransformer().fit(names_bow)

tfidf1 = tfidf_t.transform(b1)
print(tfidf1)

from sklearn.naive_bayes import MultinomialNB
# 文字列の重み付けと正規化を行う
names_tfidf = tfidf_t.transform(names_bow)
# 学習を実行
namegender_detector = MultinomialNB().fit(names_tfidf, gender_train)

print(namegender_detector.predict(tfidf1)[0])

def predict_gender(name):
    bow = bow_t.transform([name])
    n_tfidf = tfidf_t.transform(bow)
    return namegender_detector.predict(n_tfidf)[0]

print(predict_gender("のんな"))
