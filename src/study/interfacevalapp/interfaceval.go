package main

import "fmt"

// interfaceの値
// interfaceの変数を定義すると、この変数にはinterfaceの
// 任意の型のオブジェクトを保存することができる

// Human 人構造体
type Human struct {
	name  string
	age   int
	phone string
}

// Student 学生構造体
type Student struct {
	Human  // 匿名フィールドHuman
	school string
	loan   float32
}

// Employee 従業員構造体
type Employee struct {
	Human   // 匿名フィールドHuman
	company string
	money   float32
}

// SayHi HumanオブジェクトにSayHiメソッドを実装する
func (h Human) SayHi() {
	fmt.Printf("Hi, I am %s you can call me on %s\n", h.name, h.phone)
}

// Sing HumanオブジェクトにSingメソッドを実装する
func (h Human) Sing(lyrics string) {
	fmt.Println("la la la la...", lyrics)
}

// SayHi EmployeeはHumanのSayHiメソッドをオーバーロードする
func (e Employee) SayHi() {
	fmt.Printf("Hi, I am %s, I work at %s. Call me on %s\n", e.name, e.company, e.phone)
}

// Men Interface MenはHuman、StudentおよびEmployeeに実装される
type Men interface {
	SayHi()
	Sing(lyrics string)
}

func main() {
	mike := Student{Human{"Mike", 25, "222-222-XXX"}, "MIT", 0.00}
	paul := Student{Human{"Paul", 26, "111-222-XXX"}, "Harvard", 100}
	sam := Employee{Human{"Sam", 36, "444-222-XXX"}, "Golang Inc.", 1000}
	tom := Employee{Human{"Tom", 37, "222-444-XXX"}, "Things Ltd.", 5000}

	// Men型の変数iを定義
	var i Men

	// iにはStudentを保存できる
	i = mike
	fmt.Println("This is Mike, a Student:")
	i.SayHi()
	i.Sing("November rain")

	// iにはEmployeeを保存することもできる
	i = tom
	fmt.Println("This is Tom, an Employee:")
	i.SayHi()
	i.Sing("Born to be wild")

	// sliceのMenを定義する
	fmt.Println("Let's use a slice of Men and see what happens")
	x := make([]Men, 3)
	// この3つはどれも異なる要素だが、同じインターフェースを実装する
	x[0], x[1], x[2] = paul, sam, mike

	for _, value := range x {
		value.SayHi()
	}
}

// interfaceはメソッドの集合を抽象化したもの。
// 他のinterfaceではない型によって実装されなければならず、自分自身では実装することができない。
// goはinterfaceを通してduck-typingを実現できる。
