package main

import "fmt"

func main() {
	// 条件分岐の中で変数を宣言でき、この変数のスコープは条件ロジックブロック内のみ存在する
	if x := 11; x > 10 {
		fmt.Println("x is greater then 10")
		fmt.Println("x = ", x)
	} else {
		fmt.Println("x is less then 10")
		fmt.Println("x = ", x)
	}
}
