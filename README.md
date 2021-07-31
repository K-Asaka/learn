# 学習記録用リポジトリ

## スッキリわかるJava入門　第3版

### 6.2 複数クラスで構成されるプログラム

#### 複数クラスのコンパイル

複数のソースファイルを`javac`コマンドでコンパイルするには次のようにする。

```
javac ソースファイル1.java ソースファイル2.java
```


#### Javaプログラムの完成品

- Javaプログラムの完成品は、複数のクラスファイルの集合体
- 誰かに配布する場合には、すべてのクラスファイルを渡す必要がある


#### プログラムの実行方法

クラスファイルが入ったフォルダをまるごと受け取った場合は、クラス名を指定して実行する必要がある。

```
java クラス名
```

JVMは起動時に指定されたクラスの中にあるmainメソッドを呼び出してプログラムの実行を開始する。よって、Javaのプログラムを実行する人は「渡された複数のクラスファイルのうち、mainメソッドが含まれているクラスの名前」を指定する必要がある。  

#### 複数の完成クラスファイルを渡す場合の注意点

すべてのクラスファイルを渡すだけでなく、「mainメソッドが含まれるクラス名」も伝える必要がある。


### JARファイル

プログラムの完成品が複数のクラスファイルになった場合、そのままではメールで送る際などに不便である。そこでJavaでは、「複数のクラスファイルを1つにまとめるファイル形式」として**JAR**(Java ARchive)が定められている。JARファイルはZIPファイルとよく似たアーカイブファイルで、JDKに付属する`jar`コマンドでも作成することができる。
