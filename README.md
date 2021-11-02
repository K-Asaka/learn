# 学習記録用リポジトリ

## Java逆引き大全　500の極意

001～007までは説明が主のため省略。

009～011はコンパイルと実行の説明のため省略

### 012　クラスファイルから情報を取得する
「javap」コマンドは、オプションを指定して逆アセンブルを実行することにより、クラスファイルの必要な情報を取得する。
何もオプションを指定しないと、-packageオプションが設定され、javapは指定されたクラスに格納されたpublicフィールドとメソッドを表示する。
なお、javapコンパイラオプションで指定することができる主なオプションは以下の通り。

オプション | 説明
---|---
-l | 行番号とローカル変数テーブルを表示する
-public | public クラスとメンバのみを表示する
-protected | protectedとpublicのクラスとメンバだけを表示する
-package | package、protected、publicのクラスとメンバだけを表示する
-s | 内部の型シグネチャをプリントする
-c | クラスの各メソッドのために、逆アセンブルされるコードを表示する
-classpath path | javapが、クラスを探す時に使用するパスを指定する。このオプションを指定すると、デフォルト、またはCLASSPATH環境変数設定が上書きされる


**使い方**
```
javap [options] classファイル
```

### 014　データ型を理解する

Javaの基本的なデータ型
| データ型 | 値のサイズと範囲 |
| --- | --- |
| char | 2バイト文字データ |
| byte | １バイト整数(-128～127) |
| short | 2バイト整数(-32768～32767) |
| int | 4バイト整数(-2147483648～2147483647) |
| long | 8バイト整数(-9223372036854775808～9223372036854775807) |
| float | 4バイト単精度浮動小数点数 |
| double | 8バイト倍精度浮動小数点数 |
| boolean | true(真)またはfalse(偽) |

### 059　String型とStringBuffer型の使い分け

- Stringクラス  
文字列を扱うクラス。
作成した文字列の中にほかの文字列を挿入、追加、削除を行うためのメソッドがないため、オブジェクトを作成すると、オブジェクトのサイズや内容を直接変更することはできない。  
内容が変更されない固定した文字列に使用する。

- StringBufferクラス  
自在な可変長の文字列を扱うクラス。文字列の変更を行いたい時には、StringBufferクラスを使用する。作成した文字列を挿入、追加、削除を行うためのメソッドを持っている。  
内容や大きさが変更される可能性のある文字列に使用する。

### 074　オブジェクト指向プログラミングを理解する
オブジェクト指向プログラミングとは、プログラムをオブジェクト(物)の集まりとして考え、プログラム全体をオブジェクトとオブジェクトとの関連で記述することにより処理を構築していく。
部品単位で作成する小さなプログラムの構造を単純化し、これらを再利用する。
大規模なプログラムであっても効率的なプログラム開発を行うことができ、システム運用後の保守も容易になる。

### 075　クラスを理解する
Javaのプログラムには、必ず1つ以上のクラスが存在しなければならない。
クラスとは、オブジェクト(物)の設計図(型)のようなもので、その設計図には、オブジェクトがどのような性質や機能を持っているかが宣言されている。
プログラムの中で、あるオブジェクトを利用したい時、利用したいオブジェクトの設計図であるクラスを元に、オブジェクトの実体を作成する。

### 077　オブジェクトを宣言する
宣言したクラスを利用するには、インスタンスを作成する必要があり、インスタンスを作成するには、インスタンス変数を宣言する必要がある。
インスタンス変数の宣言は、通常の変数の宣言方法とほぼ同様。

`String str;`

上の例では、Stringクラスのインスタンス変数`str`を宣言している。
変数`str`は`String`型のオブジェクト(変数)と呼ぶことができる。
通常の変数を宣言した場合は、変数の実体が作成されるが、オブジェクトを宣言してもオブジェクトの実体が作成されるわけではない。

### 078　オブジェクトを作成する
宣言したオブジェクトの実体を作成するには、`new`演算子を使用する。
`new`演算子は、オブジェクトを格納するメモリ領域を確保し、オブジェクトを、対応するメモリ領域に割り当て、オブジェクトのコンストラクタ関数を呼び出す。

`str = new String("Hello Java Object");`

上の例は、`String`クラスのオブジェクト`str`がすでに宣言してある時、`str`というオブジェクトの実体を作成している。
オブジェクトの実体を作成すると`str`という変数を使用して作成した`String`オブジェクトを扱うことができるようになる。

### 079　フィールドを理解する
クラスの情報を保持するものをフィールドと呼ぶ。
フィールドの宣言は次のように行う。

```
class クラス名 {
    型 フィールド名;
}
```

次の例では、燃料(fuel)、色(iro)という情報を持つ`airplane`というクラスを宣言している。
airplaneクラスの中で宣言している`fuel`、`iro`という変数が、airplaneクラスのフィールドとなる。

```
class airplane {
    double fuel;
    String iro;
}
```

### 081　メソッドを理解する
クラスの機能を、メソッドとしてクラスのブロック内に宣言できる。
メソッドの宣言は、次のように行う。

```
class クラス名 {
    戻り値の型 メソッド名(引数) {
        文;
        return 式;
    }
}
```

以下の例では、airplaneというクラスを宣言している。
airplaeクラスには、`fuel`、`iro`というフィールドがあり、このフィールドに値をセットする`dataset`というメソッドをブロック内に宣言している。
`dataset`メソッドは「フィールドに値を設定する」という、とても単純な機能を持ったメソッド。

```
class airplane {
    double fuel;
    String iro;
    void dataset() {
        fuel = 100;
        iro = "赤";
    }
}
```

### 086　カプセル化を理解する
クラスを利用する場合に、そのクラスのフィールドを直接操作することを禁止し、クラスのメソッドを使用して間接的にフィールドを操作するように制限してクラスの独立性、安全性を高めること。

### 101　スーパークラスとサブクラスを理解する
- スーパークラス
別のクラスによって拡張された、その拡張元のクラスのこと。

- サブクラス
別のクラスによって拡張してできるクラスのこと。

クラスを拡張する時に、2つ以上のクラスをスーパークラスにはできず、どのクラスもスーパークラスは1つしかない。逆に、サブクラスはいくつでも持つことができ、サブクラスのサブクラスといったものを持つことも可能。
親子関係に例えると、スーパークラスが親で、サブクラスが子になる。

### 102　継承を理解する
サブクラスがスーパークラスのフィールドとメソッドをすべて受け継ぐことを言う。

### 107　メソッドのオーバーライドを禁止する
クラスの先頭に`final`を指定すると、そのクラスの拡張はできなくなる。また、スーパークラスのメソッドの先頭にfinalを指定すると、そのメソッドをオーバーライドできなくなる。
finalをフィールドの先頭に指定した場合は、定数を表す。

```
// このクラスは拡張できない
final class airplane {
    public void display() {
        System.out.print("飛行機の燃料は" + fuel + "です ");
        System.out.print("色は" + iro + "です");
    }
}

public airplane {
    // このメソッドはオーバーライドできない
    public final void display() {
        System.out.print("飛行機の燃料は" + fuel + "です");
        System.out.println("色は" + iro + "です");
    }
}
```

### 111　インターフェースを理解する
インターフェースはフィールドとメソッドを持つ。
インターフェースが持つフィールドは`public static final`が指定されているとみなされ、すべて定数となる。
インターフェースが持つメソッドは`public abstract`が指定されているとみなされ、すべて抽象メソッドになる。
インターフェースのオブジェクトを作成することはできない。
```
interface インターフェース名 {
    型 フィールド名 = 式;
    戻り値の型 メソッド名();
}
```

### 113　ガーベジコレクションを理解する
どこからも参照されなくなった、オブジェクトが専有しているメモリ領域を開放し再利用すること。
メモリ不足となった時に、Java仮想マシンがガーベジコレクションを自動的に始める。
ガーベジコレクタは、メモリ内を調べ、どこからも参照されなくなったメモリ領域を開放し、再度新しいオブジェクトに割り当てられるように、メモリの状態を最適化してくれる。

### 118　AWTを理解する
AWTとは「Abstract Window Toolkit」の略。
GUIを構成するための部品群のことをいう。
JDKの一部として提供され、次の記述でプログラムに読み込んで利用する。
```
import java.awt.*;
import java.awt.event.*;
```

### 119　Javaアプリケーションを理解する
Javaアプリケーションとは、単体で動作するプログラムのこと。
ソースコードにはファイル名と同じ名前のpublicクラスを定義し、プログラム実行時に処理されるMainメソッドを定義する必要がある。
また、Mainメソッドにはコマンドラインパラメータを受け取るために、String型の配列を定義する。
```
public static void main(String[]args)
```
Javaアプリケーションは、「javac」コマンドでコンパイル後、実行させるプラットフォームに対応したJava仮想マシン上で動作する。
実行するには、「java」コマンドを使用する。

### 121　Javaアプレットを理解する
JavaアプレットはWebブラウザ内で実行されるプログラムのこと。
Webページ上でしか動作させることはできない。
利点は、Webブラウザによって用意された既存のウィンドウや、ユーザーインターフェースのイベントに対する処理を実行できるところ。
また、プログラムが実行時にダウンロードされるため、実行プログラムをWebサーバー側で集中管理することが可能。
実行中は、ネットワーク上のWebサーバーからは独立して動作するため、通常のHTMLファイルによるWebページに比べてダイナミックでインタラクティブなコンテンツを作成できる。
Java対応のWebブラウザが利用可能な環境であればプログラムを実行できるため、複数の種類のクライアントコンピュータが存在する環境などでは大きな利用効果が期待できる。

### 123　アプレットを実行する
アプレットビューアを使用してアプレットを実行する。
アプレットビューアとは、アプレットの動作確認をするためのツール。
WebブラウザがアプレットをWebページで表示するのと同様の動作を、HTMLファイルを作成しなくても確認できる。
アプレットビューアは、ソースコードの先頭に記述したコメント内のHTMLを読み込んで実行される。
アプレットビューアを使用してアプレットを実行する手順は次のようになる。
```
javac Sample123.java
appletviewer Sampleq123
```

### 178　Swingを理解する
JavaのGUI部品群の1つ。  
AWTの上部に作成されたパッケージ。


### 248　スレッドを理解する
スレッドとは、実行されるプログラムの一連の処理の流れのことをいう。
mainメソッドから開始して、順番に処理を実行していくスレッドのことをメインスレッドといい、メインスレッドが終了するとプログラムも終了する。
Javaでは、1つのプログラムで2つ以上のスレッドを使用して処理を行う「マルチスレッド」を取り扱うことができる。
マルチスレッドでは1度に2つ以上の処理が実行されているように見えるが、複数のCPUを持つコンピュータ上で動くJava仮想マシンでない限り、コンピュータが一度に実行できるスレッドは1つだけ。
Javaでは、スレッド間の制御を高速に切り替え、各スレッドは次のスレッドに制御が移るまでの短時間だけ実行されている。
複数のスレッドを同時に扱えば、非常に長い時間がかかる処理が行われている間に、別のスレッドで他の処理を行うことができ、プログラムの処理効率が良くなる。


### 258　画面出力プログラムを理解する
コンソールアプリケーションでは、printメソッドや、printlnメソッドを使用して画面出力を行う。
printメソッドやprintlnメソッドは、さまざまなデータ型に対応できるようにオーバーロードされているため、異なるデータ型の引数を与えても、適切な表示が行えるようになっている。


### ストリームを理解する
#### I/Oストリームの仕組み
JavaのファイルI/Oの基本はストリーム。
ストリームとは、画面、キーボード、ファイルなどで、データを扱う時に、データを流れとして捉える抽象的な概念。
入力ストリームはデータを読み込み、出力ストリームはデータを書き出す。
Javaの入力ストリームの基本となるクラスは、java.io.InputStreamクラス。
バイト入力ストリームを表現するすべてのクラスのスーパークラスで、データを単純なバイトデータとして読み込むための基本メソッドを持っている。
Javaの出力ストリームの基本となるクラスは、java.io.OutputStream。
バイト出力ストリームを表現するすべてのクラスのスーパークラスで、データを書き出すための基本メソッドを持っている。


### ファイルの入出力手順を理解する
#### ファイルの読み込み、書き込み手順の仕組み
ファイルの入出力とは、ファイルの内容を読み込んだり書き込んだりすること。
プログラムの中で、ファイルのデータを読み込んで変数に格納し、その変数を使用して処理をしたり、ある処理の中で変数にセットした値を、ファイルに書き込んだりすることがファイルの入出力の基本。
基本的なファイル入出力の手順は次のようになる。
1. ファイルをオープンする
2. ファイルの読み込み、書き込みを行う
3. ファイルをクローズする
Javaでファイルの入出力を行うには、java.ioパッケージをインポートする必要がある。


### ネットワークプログラミングを理解する
#### Javaによるネットワークプログラミングの仕組み
Javaはネットワーク処理を念頭に設計されたプログラミング言語。
そのため、Javaによるネットワークプログラムの作成は、他のプログラミング言語よりも簡単。


### クライアント／サーバーモデルを理解する
#### クライアント／サーバーモデルの基本構造
クライアントとは、サーバーからのサービスを受け取るプログラムを実行するコンピュータのこと。
サーバーとは、他のコンピュータに対してあるサービスを提供することを目的として、特定のプログラムを常に実行し続けているコンピュータのこと。
サーバーには、メールサーバー、ファイルサーバー、Webサーバーなど、さまざまな種類のものがある。


### URLを理解する
#### URLの仕組み
URLは「Universal Resource Locator」の略で、インターネット上でのリソースファイルの場所を指し示す。
リソースファイルはテキストからマルチメディアまで、さまざまな形式がある。
URLを使用することにより、リソースファイルをサーバーから取得する際に利用するプロトコルの種類も指定できる。

▼URLの例
```
http://www.moug.net:80/boards/index.htm
```

「http」の部分はスキーム名。
ファイル転送のFTPや、ハイパーテキストのHTTP、検索システムのgopherなどが指定できる。
「//www.moug.net」の部分はサーバー名で、そのリソースを提供するインターネット上のサーバーを識別する。
スキーム名とサーバー名の区切りにはコロン「:」を指定する。
「80」の部分はポート番号で、スキームがhttpの場合は、通常は80を指定する。
80がデフォルトであるため、通常80の場合は省略される。
「boards」の部分は、サーバー内のディレクトリを表す。
「index.html」の部分は、サーバー内でのHTML文書を示すパス名を表す。
このURLからは、Internet上に「www.moug.net」というサーバーがあり、そのサーバー上のディレクトリ「boards」に「index.html」というファイルがあり、このファイルにはポート番号「80」を使用して「http」プロトコルでアクセスできる、ということがわかる。


### 簡易TCPクライアント／サーバーを事項する
#### 323、324で作成したプログラムをローカルマシンで実行
簡易TCPサーバー、簡易TCPクライアントをローカルで実行して、データの送受信を行う。
サーバーを実行すると、ポート番号2525で接続を待機する。
クライアントを実行すると、指定されたサーバーのポート番号2525へ接続を試みる。
接続が完了すると、サーバープログラムがクライアントプログラムに文字列を送信する。
クライアントプログラムは文字列を受信し、画面に表示する。


### JDBCを理解する
#### JDBCの仕組み
JDBCとは、JavaプログラムがRDBにアクセスするための、標準JavaAPI。
一般的にJDBCは「Java Database Connectivity」の略だと思われているが、JDBCはトレードマーク(TM)であり、何かの略語ではない。
標準JavaAPIを使用することにより、次のような機能を使用できる。
- JavaプログラムからRDBへの接続
- RDBに対してSQL文を発行する
- SQL文の実行結果の取得
- 実行結果に関する情報の取得
JDBCは、RDB間の差異を吸収する仕組みを備えている。
開発者は、一度JDBCをマスターすると、ターゲットとするRDBの種類が変わっても、それまでに得た知識が無駄にならないというメリットが有る。
一度JavaとJDBCでプログラムを書けば、どのようなプラットフォームでも実行できるようになる。
JDBCは、主に次のようなコンポーネントから利用できる。
- クライアントで動作するJavaアプリケーション
- Webブラウザで動作するJavaアプレット
- Webアプリケーションサーバーで動作するJSP(Java Server Pages)
- Webアプリケーション・サーバーで動作するEnterprise Java Beans


### JDBCドライバを理解する
#### JDBCドライバの仕組み
JDBCドライバは、Javaプログラムに対しAPIで定義された機能を提供し、実際にRDBへ接続して処理を行う部分でもある。
ほとんどの場合、RDBやミドルウェア製品のベンダー各社が提供しているが、サードパーティー各社からも各RDB用に提供されている。
JDBCドライバは、次の4つのタイプに分けられる。
##### タイプ1：JDBC-ODBCブリッジドライバ
Javaプログラムの実行したJDBC APIを、対応するODBC APIへ変換し、ODBCドライバに渡し、RDBにアクセスする。
このドライバはJDKに含まれ、使用するにはクライアントにインストールされている既存のODBCドライバが必要。
ODBCドライバのインストールが必要なため、アプレットから利用することはできない。

##### タイプ2：ネイティブブリッジドライバ
JDBC APIをRDB製品固有のネイティブAPIに変換し、RDBにアクセスする。
これを使用するには、RDB製品固有のクライアント・ライブラリが必要。
タイプ1ドライバと同様に、アプレットから利用することはできない。

##### タイプ3：ネットプロトコルドライバ
クライアントとRDBの間に中継サーバーを介してRDBにアクセスする。
JDBCドライバは、RDBに依存しない、独自の中間プロトコルを用いて、中継サーバーと通信する。
中継サーバーは、この独自の中間プロトコルをRDBのネイティブAPIに変換して、RDBにアクセスする。
タイプ3ドライバは、通信だけを行うものであり、タイプ4ドライバに比べてサイズが小さいため、ダウンロード時間が短くて済むという点がメリット。
しかし、システム構成が複雑になるというデメリットもある。
アプレットでもダウンロードして利用できる。

##### タイプ4：ネイティブプロトコルドライバ
RDB製品固有のネイティブAPIを完全にJavaのみで実装したもの。
クライアント・ライブラリをインストールする必要はなく、アプレットでもダウンロードして利用できる。
4つのタイプの中で最もシンプルな構成を取れる点がメリット。
しかし、JDBCドライバでRDBにアクセスするための必要な機能を持つため、タイプ3ドライバに比べて、サイズが大きくなるというデメリットも有る。


### ODBCデータソースを登録する
#### WindowsXPでODBCデータソースを登録
ODBCとは、Microsoftのg提唱するデータベースアクセス用のAPIの名称。
DBMSを問わず、共通のアプリケーション作成を実現するために開発されたもので、ODBCという枠組みの中でAPIを利用することで、違うDBMSでもある程度の汎用性を持たせることができる。
アプリケーションはデータベースのベンダーによって用意されたODBCドライバのAPIを使用し、SQLを使用してDBMSと対話する。
Accessのデータベースに、JDBC-ODBCブリッジドライバを使用してアクセスするためには、ODBCデータソースを登録する。
#### Windwos 2000でODBCデータソースを登録する
1. コントロールパネルの中の管理ツールの中のデータソース(ODBC)を開くと、ODBCデータソースアドミニストレータダイアログが表示される。ユーザーDSNタブをクリックして選択し、追加ボタンをクリックする。
2. データソースの新規作成ダイアログが表示される。この中から、Microsoft Access Driver(*.mdb)を選択し、完了ボタンをクリックする。
3. ODBC Microsoft Accessセットアップダイアログが表示される。データソース名に「URIAGE」と入力し、データベースの選択ボタンをクリックする。
4. データベースの選択ダイアログが表示される。アクセスするMDBファイルを選択し、OKボタンをクリックする。ODBC Microsoft Accessセットアップダイアログに戻るので、OKボタンをクリックする。
5. ODBCデータソースアドミニストレータダイアログに戻り、「URIAGE」という名前のデータソースが追加される。OKボタンをクリックし、ダイアログを閉じる。
以上でODBCデータソースの登録は終了。


### サーブレットを理解する
サーブレットとはCGIをJava化したプログラムであり、サーバーサイドで動くアプレットと考えることもできる。
Webサーバー上でサーブレットが動くことによって、クライアントから来たリクエストをデータベースやアプリケーションに伝えたり、逆にデータベースの検索結果やアプリケーションの処理結果などをクライアントに送ったりする。
サーブレットもアプレットと同様に、サーブレットコンテナ(Java仮想マシンのようなもの)上で動くので、プラットフォームに依存しないプログラムが作成できる。
サーブレットは、Webサーバー上で動的にページを生成するのによく使用されている。
クライアント個々のリクエストに応じた動的な結果を生成して返す場合などにサーブレットを使用することがよくある。
サーブレットの基本的な処理の流れは次のようになる。
1. クライアントから送信されたデータを読む
2. 結果を作成する
3. 結果をWebページ化(HTMLなど)する
4. Webページのタイプをクライアントに伝える
5. Webページをクライアントへ送る


### サーブレットとCGIの違い
CGIは、主にWebサーバー上に掲示板やチャット機能などを実現するのに用いられr、広く普及している。
しかし、CGIはWebサーバーとは別のアプリケーションとして動作するため、クライアントから同じCGIのプログラムを実行するリクエストがあっても、その度に新しいプロセスが起動してしまう。つまり、アクセス数の多いWebサイトでは、リクエストが多ければプロセス数が増加し、パフィーマンスが悪化してしまう。
これに対して、サーブレットはサーブレットコンテナのスレッドとして動作するため、同じプログラムであれば、Webサーバーへの負荷になるような別プロセスが複数起動されることはなく、同じプロセス内でスレッドを使用するだけで済む。
また、CGIプログラムは、リクエストの処理が終わると、プログラムも終了してしまう。それまでの処理結果をメモリ上にキャッシュしたり、データベースへの接続を維持しておいて、続きの処理をすることが困難。
これに対して、サーブレットはリクエストの処理が終わってもメモリ上に残るため、複数のリクエストから、これらを簡単に利用できる。


### サーブレットコンテナ・Tomcatを理解する
サーブレットコンテナは、サーブレットエンジンとも呼ばれ、Webサーバー上でJavaサーブレットを実行するためのJava仮想マシンのようなもの。
サーブレットコンテナはサーブレットの管理を行い、クライアントが呼び出そうとしているサーブレットを起動したり、クライアントとサーブレットのデータのやり取りを補助したりする。
「Tomcat」は、サーブレットを動かすために必要なサーブレットコンテナを搭載したWebサーバー。
サーブレットコンテナのタイプには、次の3つがある。
1. スタンドアロン型
   Webサーバーを内蔵しているタイプで、Tomcatは、デフォルトではこの動作になっている。本格的なサーバー運用には向いていないが、Webサーバーを別途インストールする必要がないため、簡単なサーブレットを実行するのに利用できる。
2. プロセス内サーブレットコンテナ
   Webサーバーとサーブレットコンテナが同じコンピュータ上のアドレス空間を共有して動作するため処理が高速になる。
3. プロセス外サーブレットコンテナ
   Webサーバーとサーブレットコンテナをそれぞれ独立したプロセスとして動作させるため、処理速度は、プロセス内サーブレットコンテナに比べて落ちるが、処理の安定性は高くなる。


### Tomcatをインストールする
Tomcat4.0のため省略。


### Tomcatを起動／終了する
Tomcat4.0のため省略。


### Tomcatの動作確認を行う
Tomcat4.0のため省略。


### サーブレットをコンパイルする
サーブレットのコンパイルでは、サーブレットAPIへのパスが必要になる。
最初に、JDKの拡張ライブラリにservlet.jarをコピーする。
この方法は、「インストール拡張」という機能を使用している。
インストール拡張とは、Javaの実行環境に、新たにクラスライブラリを追加する機能のこと。
追加されたクラスライブラリは、標準クラスライブラリと同じように、クラスパスを指定しなくてもアプリケーションから利用できる。
コピー先は、「JDKインストールディレクトリ\jre\lib\ext」。
続けてjavacコマンドでコンパイルを行う。

`javac Sample355.java`

ソースプログラムが保存されているディレクトリにクラスファイルが作成される。
インストール拡張を使用しない場合は次のようにコンパイルする。

`javac -classpath "Tomcatのインストールディレクトリ\common\lib\servlet.jar" Sample355.java`


### サーブレットを実行する
サーブレットを実行するには、Tomcatがインストールされているディレクトリ配下のディレクトリ「\webapps\examples\WEB-INF\classes」にクラスファイルをコピーする。
Webブラウザを開いて、アドレスに「http://localhost:8080/examples/servlet/クラス名」と入力する。


### サーブレット実行用の任意のディレクトリを作成する
#### Contex5 Pathを設定し、サーブレット実行用の任意のディレクトリを作成
通常のサーブレットを実行する場合、実行するサーブレットはTomcatがインストールされているディレクトリ配下のディレクトリ「\webapps\examples\WEB-INF\classes」に配置すればよいのだが、任意のディレクトリを作成し、そこにファイルを格納してファイルを管理したい場合はContext Pathを設定する。
仮に「C:\java\sample」を任意のディレクトリとする。
このディレクトリの配下に「WEB-INF」というディレクトリを作成する。
続けて、作成した「WEB-INF」ディレクトリの配下に「lib」、「classes」という2つのディレクトリを作成する。
次にContext Pathを設定する。
Context Pathを設定するには、Tomcatがインストールされているディレクトリ配下のディレクトリ「\conf」にある「server.xml」をメモ帳などで開き、「<!-- Tomcat Examples Context -->」を検索し、この行の次に以下の行を追加して保存する。

```
<Context path="/java/sample" docBase="c:\java\sample" debug="0" reloadable="true">
</Context>
```
追加後、Tomcatを再起動すると「c:\java\sample\WEB-INF\classes」ディレクトリ内にあるファイルに、http://localhost:8080/java/sample/servlet/[ファイル名]というアドレスでアクセスできるようになる。
#### 格納用ディレクトリを指定してコンパイル
```
javac -a SAMPLE\WEB-INF\classes ソースファイル.java
```


### サーブレットの初期化処理を理解する
サーブレットの初期化処理は、initメソッドで行う。
このメソッドには、引数を持つものと、引数を持たないものがある。

■引数を持つinitメソッド  
サーブレットの設定や、初期化パラメータをメソッドとして持つServletConfigオブジェクトを引数としてサーブレットコンテナに呼び出され、実行されるとServletがサービスを提供できるようになったことを意味する。
ServletコンテナはServletがインスタンス化された後、1回だけinitメソッドを実行する。
メソッドの本体の最初でsuper.init()を必ず呼び出す必要がある。
```
public void init(ServletConfig config) throws ServletException {
    super.init(config);
    // 初期化処理を記述する
}
```

■引数を持たないinitメソッド
オーバーライドする時に、super.init()を呼び出す必要はない。
引数を持つinitメソッドをオーバーライドせずに、このメソッドをオーバーライドすると自動的にGenericServlet.init(ServletConfig config)から呼び出される。
```
public void init() throws ServletException {
    // 初期化処理を記述する
}
```


### servlet初期化パラメータを取得する
まず、servlet初期化パラメータを「server.xml」に記述する。
Tomcatがインストールされているディレクトリ配下のディレクトリ「\conf」にある「server.xml」をメモ帳などで開き、「<web-app>」を検索し、この行の次に以下の行を追加して保存する。
追加する行の内容は、servletParamという初期化パラメータを定義し、値として「this is servletparameter」という文字列を設定している。
```
<servlet>
<servlet-name>Sample361</servlet-name>
<servlet-class>Sample361</servlet-class>
<init-param>
<param-name>servletParam</param-name>
<param-value>this is servletparameter</param-value>
</init-param>
</servlet>
```
Tomcatを再起動すると、設定の変更が有効になる。
「servletParam」というservlet初期化パラメータを取得して、その内容をWebブラウザに表示する。
initメソッドでgetInitParameterメソッドを使用してパラメータを取得している。


### context初期化パラメータを取得する
context初期化パラメータを「Web.xml」に記述する。
Tomcatがインストールされているディレクトリ配下のディレクトリ「\conf」にある「Web.xml」をメモ帳などで開き、「<web-app>」を検索し、この行の次に以下の行を追加して保存する。
```
<context-param>
<param-name>contextParam</param-name>
<param-value>this is contextParam</param-value>
<description>For context-wide</description>
</context-param>
```
Tomcatを再起動すると、設定の変更が有効になる。


### サーブレットの終了処理を理解する
destroyメソッドで行う。
データベースの接続をクローズする処理やバックグラウンドで実行されているスレッドを停止する処理などを記述する。
#### void destory()
Servletコンテナが実行するメソッドで、Servletがサービス提供を停止する時に実行される。
destroyメソッドはServletのserviceメソッドを実行しているスレッドがなくなるか、タイムアウト時間が過ぎた後、一度だけ実行され、Servletが使用したままの状態になっているリソースを開放する処理などを記述する。
```
public void destroy() {
    super.destory();
    // 終了処理を記述する
}
```


### サーブレットにデータを渡すHTMLを実行する
サーブレットクラスとHTMLファイルを所定の場所に配置し、http://localhost:8080/java/sample/366/Sample366.htmlへアクセス。
表示されるフォームにテキストを入力し送信ボタンを押すと、作成したサーブレットが呼び出され画面にフォームへ入力したテキストが表示される。


### サーブレットに複数のデータを渡すHTMLを実行する
サーブレットクラスとHTMLファイルを所定の場所に配置し、http://localhost:8080/java/sample/366/Sample369.htmlへアクセス。
Ctrlキーを押しながら、DATA1とDATA3を選択し送信ボタンを押す。
サーブレットが呼び出され、選択したデータが表示される。


### JSPを理解する
JSPとは、Java Server Pagesの略で、サーブレットと同じようにサーバーサイドで動作するプログラム。
HTMLの中にサーブレットを生成するJavaのプログラムコードを埋め込むことができる。
最初に表示要求が出された時点で、サーバー側でJavaファイルに変換され、それがコンパイルされて実行されるため、自分でコンパイルするという作業は必要ない。
JSPの主な特徴は次のようにまとめることができる。
- JSPはサーバーサイドで実行される。
- <% %>タグを用いて、HTMLの中にプログラムを埋め込むことができる。
- コンパイル作業が必要ない。


### JSPの実行環境を理解する
JSPを実行するには、サーブレットと同じように、Webサーバー、サーブレットコンテナが必要。
JSPの実行環境においては、サーブレットコンテナをJSPコンテナ、JSPエンジンと呼ぶ。
JSPの内部動作は次のようになる。
- Webブラウザに入力されたアドレスから、Webサーバーに対してJSPを要求する。
- Webサーバーは、Webブラウザから要求されたものがJSPであると判断すると、JSPの処理要求をJSPエンジンに渡す。
- JSPエンジンは、JSPタグを解釈し、サーブレットのソースコードに変換し、変換したサーブレットのソースコードをコンパイルする。
- コンパイルされたサーブレットがJSPエンジンで起動される。
- サーブレットがHTMLを出力し、WebサーバーがWebブラウザにHTMLを送信する。


### JSPを実行する
Webブラウザを開いて、アドレスに「http://localhost:8080/java/sample/Sample383.jsp」と入力する。


### iモードJavaの特徴
- アプリケーションのサイズ(JAR形式)は、10Kバイト以内
- スクラッチパッドのサイズは、10Kバイト以内
- ネットワーク用の通信プロトコルはHTTPのみ使用できる
- 決まった周期、時間にアプリケーションの自動起動が可能
- 画像は、GIF、アニメーションGIF、透過GIFを使用できる
- サウンドは、iモード独自の16和音MFiフォーマットを採用
- iアプリから、携帯電話の基本機能にアクセスできない


### iアプリの開発環境
以下の３つが必要。
- Java2 SDK Standard Edition(JDK)
- Java2 Micro Edition Wireless
- SDK for DoJa


### J2MEを理解する
Java 2 Micro Editionの略。
小型コンピューティングデバイス(携帯電話やPDA、カーアンビゲーション等)のために最適化されたJavaアプリケーション環境のこと。
J2MEは、仮想マシンとコアクラスを定義した「コンフィグレーション」と、特定分野固有のクラスを定義している「プロファイル」から構成される。
J2MEには、サイズが小さく、リソースを多く必要としない特別なJVMが用意されていて、これを「KVM(K Virtual Machine)」と呼ぶ。
KVMのKは10Kバイトという動作メモリサイズの小ささからきている。


### J2MEをインストールする
http://www.nttdocomo.co.jp/mc-user/i/java/tool.html
よりダウンロード。


### プログラムの作成手順
J2ME(TM) Wirelessエミュレータを起動し、プログラムを作成して実行確認。


### iアプリのAPIを理解する
iアプリの開発環境で提供されるAPIには、高レベルAPIと低レベルAPIがある。
高レベルAPIには7種類あり、少ないコード量で機種依存しないアプリケーションを作成できる。
低レベルAPIは、ゲームアプリケーションのように独自のUIを作成したり、グラフィックス処理を多用する場合に使用する。
高レベルAPIはPanelオブジェクト上で使用し、低レベルAPIはCanvasオブジェクト上で使用する。


### アプリケーションを自動起動させる
自動的に起動するアプリケーションのことを、エージェント型アプリケーションと呼ぶ。
アプリケーションをエージェント型アプリケーションにするには、「J2ME(TM) Wirelessエミュレータ」上のアプリケーション属性の設定画面で「LaunchAt」の項目に、何時間ごとに起動するかを入力する。


### ADF(JAMファイル)を理解する
ADFは「Application Descriptor File」の略で、アプリケーションのローディングや起動、ネットワークアクセスなどを制御するための情報が記述されたテキストファイル。
ADF(JAMファイル)のパラメータ
AppName：アプリケーションの名前を記述する。携帯電話上ではiアプリ一覧に表示される。
AppVer：アプリケーションのバージョンを記述する。省略可能。
PackageURL：JARファイルの配置場所のURLを255バイト以内で記述する。
AppSize：アプリケーションサイズを記述する。
AppClass：JARファイル内のメインクラス名を記述する。
AppParam：メインクラスに引き渡すパラメータを記述する。省略可能。
KvmVer：KVMのバージョンを記述する。省略可能。
SPsize：スクラッチパッドのサイズを記述する。
LastModified：最終更新日を記述する。
UseNetwork：使用するネットワークを設定する。省略可能。
TargetDevice：ターゲットとなる携帯電話の機種名を記述する。省略可能。
LaunchAt：アプリケーションを自動起動する間隔を記述する。省略可能。


### 通信事業者のJava対応
J2MEのコンフィグレーションは、すべての事業者でCLDCを採用している。
しかし、CLDCの上位にあたるプロファイルについては、NTT DoCoMoがDoJa、他社はMIDPを採用している。
また、プロファイルは各社とも独自拡張を加えており、仕様の違いからアプリケーションの移植には注意が必要。
各社のJava仕様
会社名 | プロファイル | プログラム | アプリケーションの容量
:-: | :-- | :-- | :-- 
NTT DoCoMo | DoJa(NTT独自プロファイル + 携帯メーカー拡張API) | iアプリ | 10Kバイト
J-PHONE | MIDP + JSCL(JPHONE拡張ライブラリ) | MIDlet | 30Kバイト
KDDI(Au) | MIDP + KDDI-P(KDDI拡張ライブラリ) | MIDlet | 50Kバイト


### i-JADE Liteを理解する
i-JADE Liteは、iモード対応Javaのエミュレータ。
JDKの上にiモード対応Javaのエミュレーション環境を構築している。
実際に販売されているiモード対応携帯電話に近いエミュレーション環境を提供している。
目的のiモード対応携帯電話用のi-JADE Liteをインストールすると、それぞれの機種に合わせたエミュレータを使用して、iアプリの動作確認などを行える。
J2MEとの違いは、開発環境(ビルド機能)を含んでいないこと。
i-JADE Lite単体ではiアプリの開発を行うことはできず、必ず他の開発環境と組み合わせて利用する必要がある。


### i-JADE Liteをインストール
情報が古いため省略
http://www.zentek.com/i-JADE/ja/download.html


### i-JADE Liteでアプリを実行する
情報が古いため省略


### Javaの統合開発環境を理解する
Javaの開発のためのツール一式をまとめた開発環境として、CUI環境での開発を主体としたものと、GUI環境での開発を主体としたものがある。
前者の代表格としてJDKがある。用意に開発に取り掛かれる反面、ビジュアル的にとらえにくい、コマンドの知識なしに開発が困難である、といった欠点がある。
校舎の代表格としてJBuilderがあげられる。
Visual Basicなどと同様の視覚的な開発環境を提供し、プログラム初心者でも容易にJavaプログラミングの世界に入り込むことが可能。


### JBuilderを理解する
JBuilderはBorland社からリリースされているRAD(Rapid Application Development)ツールの1つで、マウスを使ったビジュアル的な開発を可能にするだけでなく、デバッグツールなどを兼ね備えているため、開発効率の向上を図ることが可能。
JBuilderには「Personal」「Professional」「Enterprise」の3つがある。


### JBuilderをインストールする
情報が古いため省略


### JBuilderのライセンス登録をする
情報が古いため省略


### プロジェクトを理解する
JBuilderでは、1つのプログラムを「プロジェクト」という単位で扱う。
1つのプログラムには、複数のソースコードなどが関連することになるが、それらをまとめたものが「プロジェクト」。
JBuilderでは、同時に複数のプロジェクトを開いて、それらを切り替えながら編集することが可能。


### Welcomeプロジェクトを理解する
JBuilderを起動すると前回編集していたプロジェクトが表示される。
初回起動時および前回編集していたプロジェクトがない場合は、Welcomeプロジェクトが開かれる。


### プロジェクトペインを理解する
JBuilderを構成するいくつかの矩形の領域は「ペイン」と呼ばれる。


### 内容ペインを理解する
内容ペインは、JBuilderの右中央部のメインとなるペインで、プロジェクトペインで選択したファイルの内容を表示する。


### 構造ペインを理解する
構造ペインは、プロジェクトペインでソースファイルを選択した場合に、左下部に現れるペイン。
プログラム全体をツリー表示する。


### ソースビューを理解する
ソースビューは、ソースタブを選択した場合の表示のこと。
Javaプログラミングの効率を飛躍的に向上させるCodeInsightという自動補完機能が搭載されている。


### 設計ビューを理解する
設計ビューは「設計」タブを選択した場合の表示。
プログラムのGUI設計を簡単に行うための「ビジュアルデザイナ」の1つである「UIデザイナ」がデフォルトで表示される。

