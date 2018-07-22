package main

import (
	"fmt"
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
}
