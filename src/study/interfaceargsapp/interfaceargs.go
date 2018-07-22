package main

import (
	"fmt"
	"strconv"
)

// interface関数の引数
// interface引数を定義することで、関数にあらゆる型の引数を受けさせることができる
// fmt.Printlnは任意の型のデータが受け取れる。ソースには次のような定義が書いてある
// type Stringer interface {
// 	Stirng() string
// }
// つまり、Stringメソッドを持つ全ての型がfmt.Printlnによってコールされることができる

// Human 人構造体
type Human struct {
	name  string
	age   int
	phone string
}

// このメソッドを使ってHumanにfmt.Stringerを実装する
func (h Human) String() string {
	return "❰" + h.name + " - " + strconv.Itoa(h.age) + " years -  ✆ " + h.phone + "❱"
}

func main() {
	Bob := Human{"Bob", 39, "000-7777-XXX"}
	fmt.Println("This Human is : ", Bob)
}
