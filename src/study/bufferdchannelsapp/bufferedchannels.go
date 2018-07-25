package main

// Goはchannelのバッファリングの大小も指定することを許している。
// つまりchannelはいくつもの要素を保存することができる。
// ch := make(chan bool, 4)は4つのbool型の要素を持てるchannelを作成する。
// このchannelの中で、前の4つの要素はブロックされずに入力することができる。
// 5番目の要素が入力された場合、コードはブロックされ、その他のgoroutineがchannelから
// 要素を取り出すまで空間を退避する。
//
// ch := make(chan type, value)
//
// value == 0 ! バッファリング無し(ブロック)
// value > 0 ! バッファリング(ブロック無し、value個の要素まで)

import "fmt"

func main() {
	c := make(chan int, 2) // 2を1に修正するとエラーが発生する。2を3に修正すると正常に実行される
	c <- 1
	c <- 2
	fmt.Println(<-c)
	fmt.Println(<-c)
}
