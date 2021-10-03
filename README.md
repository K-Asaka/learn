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
