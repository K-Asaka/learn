package main

import "fmt"

func main() {
	sum := 0
	// 複数の代入操作は,で区切って行える
	// i, j = i+1, j-1
	for index := 0; index < 10; index++ {
		sum += index
	}
	fmt.Println("sum is equal to ", sum)

	// expression1とexpression3を省略
	// whileと同じ形になる
	sum = 1
	for sum < 1000 {
		sum += sum
	}
	fmt.Println("sum is equal to ", sum)

	// breakであれば10、9、8、7、6
	// continueの場合は10、9、8、7、6、4、3、2、1
	for index := 10; index > 0; index-- {
		if index == 5 {
			break // またはcontinue
		}
		fmt.Println(index)
	}
	// breakとcontinueはタグを添えることができる。
	// 複数ネストしたループで外側のループからジャンプする際に使用される。

	// rangeと組み合わせてarray、slice、map、stringのデータを読み込める
	m := map[string]int{"one": 1, "two": 2, "three": 3}
	for k, v := range m {
		fmt.Println("map's key:", k)
		fmt.Println("map's val:", v)
	}

	// 宣言して使用されていない変数に対してコンパイラがエラーを出すのに対応する
	// _で必要のない戻り値を捨てる
	for _, v := range m {
		fmt.Println("map's val:", v)
	}
}
