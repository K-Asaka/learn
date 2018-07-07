package main

import "fmt"

type testInt func(int) bool // 関数の型を宣言する

func isOdd(integer int) bool {
	if integer%2 == 0 {
		return false
	}
	return true
}

func isEven(integer int) bool {
	if integer%2 == 0 {
		return true
	}
	return false
}

// ここでは宣言する関数の型を引数のひとつとみなす。
func filter(slice []int, f testInt) []int {
	var result []int
	for _, value := range slice {
		// 渡された関数を使って値をチェック
		if f(value) {
			result = append(result, value)
		}
	}
	return result
}

// 共有のインタフェースを書くときに関数を値と型にみなすのは非常に便利
// この例でtestIntという型は関数の型の一つだった。
// ふたつのfilter関数の引数と戻り値はtestIntの型と同じだが、より多くのロジックを実現することができる。

func main() {
	slice := []int{1, 2, 3, 4, 5, 7}
	fmt.Println("slice = ", slice)
	odd := filter(slice, isOdd) // 関数の値渡し
	fmt.Println("Odd elements of slice are: ", odd)
	even := filter(slice, isEven) // 関数の値渡し
	fmt.Println("Even elements of slice are: ", even)
}
