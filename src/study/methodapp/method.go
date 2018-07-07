package main

import (
	"fmt"
	"math"
)

// Rectangle 長方形構造体
type Rectangle struct {
	width, height float64
}

// Circle 円構造体
type Circle struct {
	radius float64
}

// area関数は、Rectangleに所属するわけではなく、r1、r2を受けて面積を計算している。
// この方法で面積を求めると、正方形、五角形などと多角形の面積も求めようとしたとき、そのための関数を増やすしかない。
// 関数名もそれぞれのものを用意しなければならず煩雑になる。
// 概念からして、面積は形状の一属性。
// methodはある型に属する。
// methodの文法は関数の宣言の文法と同じ。
// ただ、funcの後にreceiver(methodがくっついているということ)を追加する。
func area(r Rectangle) float64 {
	return r.width * r.height
}

// method area()はある形状に由来して発生している。
// Rectangle.area()の主語はRectangle、area()はRectangleに属するメソッドで外側の関数ではない。
// Rectangleにはフィールドlengthとwidthが存在する。
// 同時にarea()メソッドが存在する。
// methodの文法は以下の通り

func (r Rectangle) area() float64 {
	return r.width * r.height
}

func (c Circle) area() float64 {
	return c.radius * c.radius * math.Pi
}

// methodは、カスタム定義型、ビルトイン型、structなどあらゆる型でも定義することができる。
// カスタム定義型は次のような宣言で実現する
// type typeName typeLiteral

func main() {
	r1 := Rectangle{12, 2}
	r2 := Rectangle{9, 4}
	c1 := Circle{10}
	c2 := Circle{25}

	fmt.Println("Area of r1 is: ", area(r1))
	fmt.Println("Area of r2 is: ", area(r2))
	fmt.Println("Area of c1 is : ", c1.area())
	fmt.Println("Area of c2 is: ", c2.area())

}
