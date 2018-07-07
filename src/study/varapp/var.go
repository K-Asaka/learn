package main

import (
	"fmt"
)

// グローバル変数の定義(説明はmain関数内のコメント参照)
var isActive bool                   // グローバル変数の宣言
var enabled, disabled = true, false // 型を省略した宣言

func test() {
	fmt.Println("test() ----")
	var available bool // 通常の宣言
	valid := false     // 短縮宣言
	available = true
	enabled = false // enabledをtest()内で変更
	fmt.Printf("isActive = %t\n", isActive)
	fmt.Printf("enabled = %t, disabled = %t\n", enabled, disabled)
	fmt.Printf("available = %t\n", available)
	fmt.Printf("valid = %t\n", valid)
	fmt.Println("test() -----")

	isActive = false // isActiveをtest()内で変更
}

func main() {
	// varキーワードを使い変数を定義
	// var variableName Type
	// 変数の初期化
	// var variableName Type = value

	// 複数の変数を定義する。すべてTypeに指定した型になる
	// var vname1, vname2, vname3 Type
	// 複数の変数を同時に初期化
	// var vname1, vname2, vname3 Type = v1, v2, v3

	// 上記は次のようにもかける
	// var vname1, vname2, vname3 = v1, v2, v3
	// 更に簡単に
	// vname1, vname2, vname3 := v1, v2, v3
	// 3つの変数を定義し、それぞれ個別に初期化する。
	// コンパイラは初期化する値に従って自動的にふさわしい型を導き出す

	// :=には制限があり、関数の内部でしか使用できない。
	// 一般的にはvarでグローバル変数が定義される。

	// _は特別な変数名で、どのような値もすべて捨てる
	_, b := 34, 35

	fmt.Printf("b = %d\n", b)

	// Goはすでに宣言されている未使用の変数をコンパイル時にエラーとして出力する

	// 定数は、プログラムがコンパイルされる段階で値が決定される。
	// プログラム実行中に値の変更は許されない。
	// const constantName = value
	// 必要があれば定数の型を明示できる
	// const Pi float32 = 3.1415926

	const Pi = 3.1415926
	const i = 10000
	const MaxThread = 10
	const prefix = "astaxie_"

	isActive = true
	fmt.Printf("isActive = %t\n", isActive)
	fmt.Printf("enabled = %t, disabled = %t\n", enabled, disabled)
	test()
	fmt.Printf("isActive = %t\n", isActive)
	fmt.Printf("enabled = %t, disabled = %t\n", enabled, disabled)

	// ビルトイン基本型
	// Boolean
	// bool値の型はbool。値はtrueもしくはfalse。デフォルトはfalse。
	// 数値型
	// 整数型には符号付きと符号無しがある。
	// intとuintをサポート。
	// この2つの型の長さは同じだが、実際の長さはコンパイラによって決定される。
	// 直接bit数を指定できる型もある。
	// rune, int8, int16, int32, int64
	// byte, uint8, uint16, uint32, uint64
	// runeはint32のエイリアス、byteはuint8のエイリアス
	// これらの型の変数間は相互に代入または操作を行えない。
	// 以下のコードはエラーになる
	// var a int8
	// var b int32
	// c := a + b
	// intの長さは32bitだが、intとint32もお互いに利用することはできない

	// 浮動小数点の型にはfloat32とfloat64がある。デフォルトはfloat64。

	// 複素数もサポートされている。
	// デフォルト型はcomplex128(64bit実数+64bit虚数)。
	// 小さいのが必要であれば、complex64(32bit実数+32bit虚数)もある。
	// 複素数の形式はRE+IMi。REが実数部分、IMが虚数部分になる。最後のiは虚数単位。
	// 使用例は以下のコード。
	// var c complex64 = 5+5i
	// //output: (5+5i)
	// fmt.Printf("Value is: %v", c)

	// 文字列
	// 文字列はすべてUTF-8が採用されている。
	// 文字列は一対のダブルクォーテーション("")またはバッククォート(``)で括られることで定義される。
	// バッククォートは複数行にわたった文字列を定義する時に使う。
	// 型はstring。
	// 文字列は変更することができない。以下のコードはエラーになる。
	// var s string = "hello"
	// s[0] = 'c'
	// 変更したい時は以下のようにする。
	// s := "hello"
	// c := []byte(s)	// 文字列sを[]byte型にキャスト
	// c[0] = 'c'
	// s2 := string(c)	// もう一度string型にキャスト
	// fmt.Printf("%s\n", s2)

	// +演算子を使って文字列を連結できる
	// s := "hello,"
	// m := " world"
	// a := s + m
	// fmt.Printf("%s\n", a)
	// 文字列の修正も以下の通り書ける。
	// s := "hello"
	// s = "c" + s[1:]	// 文字列を変更することはできないが、スライスは行える
	// fmt.Printf("%s\n", s)
	// 複数行の文字列を宣言
	// m := `hello
	//       world`
	// `で括られた文字列はRaw文字列。コード内の形式がそのままプリント時の形式になる。
	// 改行はそのまま出力される。

	// エラー型
	// ビルトインのerror型がある。
	// エラー情報の処理に使用される。Goのpackageの中にはエラー処理を行うerrorsというパッケージがある。
	// err := errors.New("emit macho dwarf: elf header corrupted")
	// if err != nil {
	//     fmt.Print(err)
	// }

	// 複数の定数・変数を宣言する場合、または複数のパッケージをインポートする場合、グループ化による方法で宣言できる。
	// import (
	//     "fmt"
	//     "os"
	// )
	// const (
	//     i = 100
	//     pi = 3.1415
	//     prefix = "Go_"
	// )
	// var (
	//     i int
	//     pi float32
	//     prefix string
	// )

	// iota列挙型
	// iotaというキーワードはenumを宣言する際に使用される。
	// デフォルト値は0から始まり、順次1が追加される。
	//const (
	//	x = iota	// x == 0
	//	y = iota	// y == 1
	//	z = iota	// z == 2
	//	w			// 定数の宣言で値を省略した場合、デフォルト値は前の値と同じになる。ここではw=iotaと宣言していることとおなじになるため、w == 3となる。上のyとｚもiotaを省略可能
	//)
	//const v = iota	// constキーワードが出現するたびにiotaは置き直される。ここではv == 0
	//
	//const (
	//	e, f, g = iota, iota, iota	// e=0,f=0,g=0 iotaの同一行は同じ
	//)

	// Goプログラムのデザインルール
	// 大文字で始まる変数はエクスポート可能。他のパッケージから読むことができるパブリックな変数になる。
	// 小文字で始まる変数はエクスポートできない。プライベート変数。
	// 大文字で始まる関数も同じ。classの中でpublicキーワードによってパブリックになっているのと同じ。
	// 小文字で始まる関数はprivateキーワードのプライベート関数。

	// array
	// 配列。定義は以下の通り。
	// var arr [n]type
	// [n]typeの中で、nは配列の長さを表す。
	// typeは保存する要素の型を示す。
	// []を通して値の取得および代入を行う。

	var arr [10]int                                 // int型の配列を宣言
	arr[0] = 42                                     // 配列のインデックスは0から始まる
	arr[1] = 13                                     // 代入操作
	fmt.Printf("The first element is %d\n", arr[0]) // データを取得して42を返す
	fmt.Printf("The last element is %d\n", arr[9])  // 値が代入されていない最後の要素を返す。デフォルトでは0が返る

	// 長さも配列の一部のため、[3]intと[4]intは異なる型になる。
	// 配列も長さを変えることはできない。配列間の代入は値渡し。
	// 一つの配列が関数の引数となった場合、渡されるのは配列のコピーであり
	// ポインタではない。ポインタを使う場合はslice型を使う
	// 配列は:=で宣言することができる。
	// a := [3]int{1, 2, 3}	// 長さが3のint配列を宣言
	// b := [10]int{1, 2, 3}	// 長さが10のint配列を宣言。この中で3つの要素の初期値は1、2、3で、その他のデフォルトは0
	// c := [...]int{4, 5, 6}	// 長さを`...`で省略することができる。Goは自動で要素数から長さを計算する。

	// 配列に配列を保存する二次元配列。
	// 二次元配列を一つ宣言する。この配列は2つの配列を要素とし、各配列には4つのint型の要素が含まれる
	// doubleArray := [2][4]int{[4]int{1, 2, 3, 4}, [4]int{5, 6, 7, 8}}
	// 簡略化した記述
	// doubleArray := [2][4]int{{1, 2, 3, 4}, {5, 6, 7, 8}}

	// slice
	// 動的な配列が必要な場合、そのようなデータ構造をsliceと呼ぶ。
	// sliceは、本当の意味での動的な配列ではなく、単なる参照型。
	// sliceは常に低レイヤのarrayを指している。
	// sliceの宣言もarrayと同様に長さを指定する必要はない。

	// var fslice []int

	// sliceを宣言すると同時にデータを初期化する
	// slice := []byte {'a', 'b', 'c', 'd'}

	// sliceはひとつの配列またはすでに存在するsliceの中から宣言することができる。
	// sliceはarray[i:j]で取得することができる。
	// iは配列の開始位置、jは終了位置。ただしarray[j]は含まない。
	// 長さはj-iとなる。

	// //10個の要素を宣言する。要素の型はbyteの配列
	// var ar = [10]byte {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}
	// //byteを含む2つのsliceを宣言
	// var a, b []byte
	// //aポインタ配列の3つ目の要素から始まり、5つ目の要素まで
	// a = ar[2:5]
	// //現在aの持つ要素はar[2]、ar[3]、ar[4]
	// //bは配列arのもう一つのslice
	// b = ar[3:5]
	// //bの要素はar[3]とar[4]

	// sliceと配列は宣言時に区別される。
	// 配列を宣言する時、[]の中で配列の長さを明示するかまたは...で自動的に長さを計算する。
	// sliceを宣言する時は、[]内には文字はない。

	// sliceには便利な操作がある。
	// sliceのデフォルト開始位置は0。ar[:n]などはar[0:n]と等価。
	// sliceの2つ目の値のデフォルトは配列の長さ。ar[n:]はar[n:len(ar)]と等価。
	// 配列の中から直接sliceを取り出す場合は、ar[:]というような形で指定することができる。
	// これは、デフォルトの始めの値は0で、2つ目の値は配列の長さであるため、ar[0:len(ar)]と等価であるため。

	// sliceの操作の例
	// 配列を宣言
	var array = [10]byte{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}
	// sliceを2つ宣言
	var aSlice, bSlice []byte

	// 便利な操作のデモンストレーション
	aSlice = array[:3] // aSlice = array[0:3]と等価
	aSlice = array[5:] // aSlice = array[5:10]と等価
	aSlice = array[:]  // aSlice = array[0:10]と等価

	// sliceからsliceを取り出す
	aSlice = array[3:7]
	bSlice = aSlice[1:3] // bSliceにはaSlice[1]、aSlice[2]が含まれる
	bSlice = aSlice[:3]  // bSliceにはaSlice[0]、aSlice[1]、aSlice[2]が含まれる
	bSlice = aSlice[0:5] // sliceのsliceに対してcapの範囲内で拡張することができる。この時bSliceには以下の要素が含まれる：d,e,f,g,h
	bSlice = aSlice[:]   // bSliceにはaSliceのすべての要素が含まれる：d,e,f,g

	fmt.Println(bSlice)

	// sliceは参照型なので、この中の要素の値を変更すると、そのほかのすべての参照でも値が変更される。
	// 概念上では、sliceは構造体。この構造体には3つの要素が含まれる。
	// ・ポインタ。配列中のsliceが示す開始位置を指す。
	// ・長さ。つまりsliceの長さ
	// ・最大の長さ。sliceの開始位置から配列の最後の位置までの長さ

	// sliceの便利なビルトイン関数
	// len　sliceの長さを取得する
	// cap　sliceの最大容量を取得する
	// append　sliceに対して一つまたは複数の要素を追加する。その後sliceと同じ型のsliceを返す
	// copy　もとのsliceのsrcの要素をdstにコピーし、コピーした要素の個数を返す

	// appendはsliceが参照した配列の内容を変更し得る。そのため、参照先と同一の配列の他のsliceにも影響する。
	// しかし、sliceの中に余分なスペースがない((cap-len)==0)場合、動的なメモリから新たな配列空間が割り当てられる。
	// 返されるslice配列のポインタは、その空間を指す。もとの配列の内容は変わらない。
	// そのため、この配列を参照している他のsliceは影響を受けない。

	// Go1.2より、sliceは三引数のsliceをサポートするようになった。
	// これまでのslice
	// var array [10]int
	// slice := array[2:4]
	// この例では、sliceの要素数は8。新しいバージョンでは、要素数を指定できる。
	// slice := array[2:4:7]
	// これの要素数は7-2、即ち5。このように生成された新しいsliceでは最後の3つの要素にアクセスする方法がなくなる。
	// もしsliceがarray[:i:j]のような形式だった場合は、第一引数は空とみなされ、デフォルトの0となる。

	// map
	// mapの概念もPythonのディクショナリ。この形式はmap[keytype]valueType。
	// mapの読み込みと代入はsliceと似ている。keyを通して操作する。ただ、sliceのindexはint型のみになる。
	// mapには多くの型がある。intでもstringでも、==と!=演算子が定義されているすべての型でもかまわない。

	// keyを文字列で宣言。値はintとなるディクショナリ。この方法は使用される前にmakeで初期化される必要がある。
	//var numbers map[string]int
	// もうひとつのmapの宣言方法
	numbers := make(map[string]int)
	numbers["one"] = 1  // 代入
	numbers["ten"] = 10 // 代入
	numbers["three"] = 3
	fmt.Println("３つ目の数字は：", numbers["three"]) // データの取得

	// このmapは普段目にする表と同じ。左の列にkey、右の列に値がある。
	// mapを使う段階での注意点
	// mapは順序がない。毎回mapの出力は違ったものになるかもしれない。
	// indexで値を取得することはできず、かならずkeyを使うことになる。
	// mapの長さは固定ではない。sliceと同じで、参照型の一種。
	// ビルトインのlen関数をmapに適用すると、mapがもつkeyの個数を返す。
	// mapの値は簡単に修正することができる。numbers["one"]=11というように、keyがoneのディクショナリの値を11に変えることができる。
	// mapは他の基本型と異なり、thread-safeではない。複数のgo-routineを扱う際には必ずmutex lockメカニズムを使用する必要がある。

	// mapの初期化ではkey:valの方法で初期値を与えることができる。また同時にmapには標準でkeyが存在するか確認する方法が存在する。

	// deleteでmapの要素を削除する
	// ディクショナリを初期化する
	rating := map[string]float32{"C": 5, "Go": 4.5, "Python": 4.5, "C++": 2}
	fmt.Println(rating)
	// mapは2つの戻り値がある。2つ目の戻り値では、もしkeyが存在しなければ、okはfalseに、存在すればokはtrueになる。
	csharpRating, ok := rating["C#"]
	if ok {
		fmt.Println("C# is in the map and its rating is ", csharpRating)
	} else {
		fmt.Println("We have no rating associated with c# in the map")
	}
	delete(rating, "C") // keyがCの要素を削除する
	fmt.Println(rating)

	// mapは参照型の一種なので、もし2つのmapが同時に同じポインタを指している場合、一つの変更で、もう一つにも変更が行われる
	m := make(map[string]string)
	m["Hello"] = "Bonjour"
	m1 := m
	fmt.Println(m)
	m1["Hello"] = "Salut" // この時、m["Hello"]の値もすでにSalutになっている
	fmt.Println(m)

	// make、new操作
	// makeはビルトイン型(map、sliceおよびchannel)のメモリの割り当て。
	// newは各型のメモリを割り当てる。
	// newは本質的には他の言語で使われる同名の関数と機能が同じ。
	// new(T)はゼロサプレスされたT型のメモリ空間を割り当て、そのアドレスを返す。
	// すなわち*T型の値。ポインタを返すということ。
	// 新たに割り当てられた型Tのゼロ値。

	// make(T, args)とnew(T)は異なる機能を持っている。
	// makeはslice、mapまたはchannelを作成し、初期値(非ゼロ値)を持つT型を返すのみで、*Tではない。
	// 本質的には、この3つの型が異なる点はデータ構造を指し示す参照が使用される前に初期化されているということ。
	// 例えば、データ(内部array)を指し示すポインタ、長さ、容量による3点で記述されるsliceの各項目が初期化される前は、sliceはnil。
	// slice、map、channelにとって、makeは内部のデータ構造を初期化し、適当な値で埋め尽くされる。
	// makeは初期化後の(非ゼロの)値を返す。

	// ゼロ値
	// 変数が埋められる前のデフォルト値。通常は0。
	// int 		0
	// int8		0
	// int32	0
	// int64	0
	// uint		0x0
	// rune		0 	// runeの実際の型はint32
	// byte		0x0	// byteの実際の型はuint8
	// float32	0	// 長さは4byte
	// float64	0	// 長さは8byte
	// bool		false
	// string	""

}
