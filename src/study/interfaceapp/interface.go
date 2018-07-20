package main

import "fmt"

// interface型ではメソッドのセットを定義する
// あるオブジェクトがインタフェースとなるすべてのメソッドを実装するとしたら、
// このオブジェクトはこのインタフェースを実装することになる。

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

// Employee 社員構造体
type Employee struct {
	Human   // 匿名フィールドHuman
	company string
	money   float32
}

// SayHi HumanオブジェクトにSayHiメソッドを実装する
func (h *Human) SayHi() {
	fmt.Printf("Hi, I am %s you can call me on %s\n", h.name, h.phone)
}

// Sing HumanオブジェクトにSingメソッドを実装する
func (h *Human) Sing(lyrics string) {
	fmt.Println("La la, la la la, la la la la la...", lyrics)
}

// Guzzle HumanメソッドにGuzzleメソッドを実装する
func (h *Human) Guzzle(beerStein string) {
	fmt.Println("Guzzle Guzzle Guzzle...", beerStein)
}

// SayHi EmployeeはHumanのSayHiメソッドをオーバーロードする
func (e *Employee) SayHi() {
	fmt.Printf("Hi, I am %s, I work at %s. Call me on %s\n", e.name, e.company, e.phone)
}

// BorrowMoney StudentはBorrowMoneyメソッドを実装する
func (s *Student) BorrowMoney(amount float32) {
	s.loan += amount // (again and again and...)
}

// SpendSalary EmployeeはSpendSalaryメソッドを実装する
func (e *Employee) SpendSalary(amount float32) {
	e.money -= amount // More vodka please!!! Get me through the day!
}

// interfaceを定義する

// Men Men interface
type Men interface {
	SayHi()
	Sing(lyrics string)
	Guzzle(beerStein string)
}

// YoungChap YoungChap interface
type YoungChap interface {
	SayHi()
	Sing(song string)
	BorrowMoney(amount float32)
}

// ElderlyGent ElderlyGent interface
type ElderlyGent interface {
	SayHi()
	Sing(song string)
	SpendSalary(amount float32)
}

// interfaceは任意のオブジェクトで実装できる
// Men interfaceはHuman、Student及びEmployeeによって実装される
// StudentはMenとYoungChapの2つのinterfaceを実装することになる
// 任意の型は空のinterfaceを実装している
// これには0個のメソッドが含まれるinterface

func main() {

}
