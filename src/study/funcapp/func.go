package main

import "fmt"

// funcでmaxという名前の関数を宣言する
// a、bの中から最大値を返す
func max(a, b int) int {
	// 関数は一つまたは複数の引数をとり、各引数の後には型が続く。
	// ,をデリミタとする。
	// 関数は複数の戻り値を持ってかまわない。
	// 戻り値の変数を宣言することもできるが、省略し型だけを宣言しても良い
	// ここではint型の値を1つ戻す。
	// もしひとつの戻り値しか存在せず、また戻り値の変数が宣言されていなかった場合、戻り値の括弧を省略することができる。
	// もし戻り値がなければ、最後の戻り値の情報も省略することができる。
	// もし戻り値があれば、関数の中でreturn文を追加する必要がある。
	if a > b {
		return a
	}
	return b
}

// SumAndProduct 足し算と掛け算の結果を返す
// exportされる関数は、「関数名 説明」のコメントを付ける
//func SumAndProduct(A, B int) (int, int) {
//	// 複数の戻り値
//	return A + B, A * B
//}
func SumAndProduct(A, B int) (add int, Multiplied int) {
	// 関数がエクスポートされるのであれば、オフィシャルではなるべく戻り値に名前を付けるよう勧めている。
	// 名前のわからない戻り値はコードが簡潔になっても、生成されるドキュメントの可読性がひどくなる。
	add = A + B
	Multiplied = A * B
	return
}

// 可変長引数
func myfunc(arg ...int) {
	// arg ...intは、Goにこの関数が不特定多数の引数を受け付けることを伝える。
	// この引数の型はすべてintになる。関数ブロックの中で変数argはintのsliceになる。
	for _, n := range arg {
		fmt.Printf("And the number is: %d\n", n)
	}
}

// 値渡しの確認
func add1(a int) int {
	a = a + 1 // aの値を変更する
	return a  // 新しい値を返す
}

// 参照渡しの確認
func add2(a *int) int {
	*a = *a + 1 // aの値を修正している
	return *a   // 新しい値を返す
}

func main() {
	x := 3
	y := 4
	z := 5

	maxXy := max(x, y) // 関数max(x, y)をコール
	maxXz := max(x, z) // 関数max(x, z)をコール

	fmt.Printf("max(%d, %d) = %d\n", x, y, maxXy)
	fmt.Printf("max(%d, %d) = %d\n", x, z, maxXz)
	fmt.Printf("max(%d, %d) = %d\n", y, z, max(y, z)) // 直接コールしてもかまわない

	xPLUSy, xTIMESy := SumAndProduct(x, y)

	fmt.Printf("%d + %d = %d\n", x, y, xPLUSy)
	fmt.Printf("%d * %d = %d\n", x, y, xTIMESy)

	myfunc(1, 2, 3, 4, 5, 4, 3, 2, 1)

	fmt.Println("x = ", x)
	x1 := add1(x) // add1(x)をコール
	fmt.Println("x+1 = ", x1)
	fmt.Println("x = ", x)

	fmt.Println("x = ", x)
	x2 := add2(&x) // add1(&x)をコールしてxのアドレスを渡す
	fmt.Println("x+1 = ", x2)
	fmt.Println("x = ", x) // 値が変わっている
	// ポインタを渡すことで複数の関数が同じオブジェクトに対して操作を行える。
	// ポインタ渡しは比較的軽い(8バイト)。
	// ポインタを使って大きな構造体を渡すことができる。
	// channel、slice、mapの3つの型はメカニズムを実現するポインタのようなもの。
	// 直接渡すことができる。アドレスを取得してポインタを渡す必要はない。
	// もし関数がsliceの長さを変更する場合は、アドレスを取得し、ポインタを渡す必要がある。

}
