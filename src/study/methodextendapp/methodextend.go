package main

import "fmt"

// メソッドの継承

// Human 人構造体
type Human struct {
	name  string
	age   int
	phone string
}

// Student 学生構造体
type Student struct {
	Human  // 匿名フィールド
	school string
}

// Employee 社員構造体
type Employee struct {
	Human   // 匿名フィールド
	company string
}

// SayHi human上でメソッドを定義
func (h *Human) SayHi() {
	fmt.Printf("Hi, I am %s you can call me on %s\n", h.name, h.phone)
}

// SayHi EmployeeのmethodでHumanのmethodを書き直す
func (e *Employee) SayHi() {
	fmt.Printf("Hi, I am %s, I work at %s. Call me on %s\n", e.name, e.company, e.phone)
}

func main() {
	mark := Student{Human{"Mark", 25, "222-222-YYYY"}, "MIT"}
	sam := Employee{Human{"Sam", 45, "111-888-XXXX"}, "Golang Inc"}

	mark.SayHi()
	sam.SayHi()
}
