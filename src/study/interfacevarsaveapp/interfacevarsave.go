package main

import (
	"fmt"
	"reflect"
	"strconv"
)

// interface変数に保存されているオブジェクトの型を確認する方法
// ・Comma-okアサーション
// value, ok = element.(T)
// valueは変数の値を指し、okはbool型。elementはinterface変数、Tはアサーションの型。
// もしelementにT型の数値が存在していなければ、okにはtrueが返される。そうでなければfalseが返る

// ・switchテスト
// element.(type)という文法はswitchの外のロジックで使用できない
// もしswitchの外で型を判断したい場合はcomma-okを使う

// Element 空のinterface
type Element interface{}

// List Elementのslice
type List []Element

// Person Person構造体
type Person struct {
	name string
	age  int
}

// Stringメソッドを定義する。fmt.Stringerを実装する
func (p Person) String() string {
	return "(name: " + p.name + " - age: " + strconv.Itoa(p.age) + " years)"
}

func main() {
	list := make(List, 3)
	list[0] = 1       // an int
	list[1] = "Hello" // a string
	list[2] = Person{"Dennis", 70}

	for index, element := range list {
		// comma-okアサーション
		if value, ok := element.(int); ok {
			fmt.Printf("list[%d] is an int and its value is %d\n", index, value)
		} else if value, ok := element.(string); ok {
			fmt.Printf("list[%d] is a string and its value is %s\n", index, value)
		} else if value, ok := element.(Person); ok {
			fmt.Printf("list[%d] is a Person and its value is %s\n", index, value)
		} else {
			fmt.Printf("list[%d] is of a different type\n", index)
		}
		// ifの中で変数の初期化が許されている
		// アサーションの型が増えれば増えるほど、ifelseの数も増える

		// switchテスト
		switch value := element.(type) {
		case int:
			fmt.Printf("list[%d] is an int and its value is %d\n", index, value)
		case string:
			fmt.Printf("list[%d] is a string and its value is %s\n", index, value)
		case Person:
			fmt.Printf("list[%d] is a Person and its value is %s\n", index, value)
		default:
			fmt.Printf("list[%d] is of a different type\n", index)
		}

	}

	// 組み込みinterface
	// Structの匿名フィールドのようなロジックをinterfaceにも導入できる。
	// もしinterface1がinterface2の組み込みフィールドであれば、interface2は暗黙的にinterface1のメソッドを含むことになる。
	// ソースパッケージのcontainer/heapの中に次のような定義があるのを確認できる。

	// tyep Interface interface {
	//  	sort.Interface 	// 組み込みフィールドsort.Interface
	//  	Push(x interface{}) 	// a Push method to push elements into the heap
	//  	Pop() interface{}		// a Pop elements that pops elements from the heap
	// }

	// sort.Interfaceは組み込みフィールド。
	// sort.Interfaceのすべてのメソッドを暗黙的に含んでいる。
	// 以下の3つのメソッド。

	// type Interface interface {
	//  	// Len is the number of elements in the collection.
	//  	Len() int
	//  	// Less returns whether the element with index i should sort
	//  	// before the element with index j.
	//  	Less(i, j int) bool
	//  	// Swap swaps the elements with indexes i and j.
	//  	Swap(i, j int)
	// }

	// もう一つの例はioパッケージの中にあるio.ReadWriter。
	// この中にはioパッケージのReaderとWriterの2つのinterfaceを含んでいる。

	// io.ReadWriter
	// type ReadWriter interface {
	//  	Reader
	//  	Writer
	// }

	// リフレクション
	// リフレクションはプログラムの実行時の状態を検査することができる。
	// 一般的に使用しているパッケージはreflectパッケージ。
	// どのようにreflectパッケージを使うかはオフィシャルのドキュメント参照。
	// https://blog.golang.org/laws-of-reflection

	// reflectを使うには3つのステップに分けられる。
	// リフレクションは型の値(これらの値はすべて空のインタフェースを実装している)。
	// まずこれをreflectオブジェクトに変換する必要がある(reflect.Typeまたはreflect.Value。異なる状況によって異なる関数をコールする)
	// この2つを取得する方法は
	// t := reflect.TypeOf(i)		// 元のデータを取得する。tを通して型定義の中のすべての要素を取得することができる
	// v := reflect.ValueOf(i)		// 実際の値を取得する。vを通して保存されている中の値を取得することができる。値を変更することもできる
	// reflectオブジェクトに変換した後、reflectオブジェクトを対応する値に変換する。
	// 例えば
	// tag := t.Elem().Field(0).Tag		// structの中で定義されているタグを取得
	// name := v.Elem().Field(0).String()		// はじめのフィールドに保存されている値を取得する
	// reflectの値を取得することで対応する型と数値を返すことができる。

	x := 3.4
	v := reflect.ValueOf(x)
	fmt.Println("type:", v.Type())
	fmt.Println("kind is float64:", v.Kind() == reflect.Float64)
	fmt.Println("value:", v.Float())

	// 最後にリフレクションを行ったフィールドは修正できる必要がある。
	// 値渡しと参照渡しも同じ道理。
	// リフレクションのフィールドが必ず読み書きできるということは、以下の様に書いた場合、エラーが発生する。

	// x := 3.4
	// v := reflect.ValueOf(x)
	// v.SetFloat(7.1)

	// もし対応する値を変更したい場合、以下のように書く。

	// x := 3.4
	// p := reflect.ValueOf(&x)
	// v := p.Elem()
	// v.SetFloat(7.1)

}
