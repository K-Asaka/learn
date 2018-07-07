package main

import (
	"fmt"
	"os"
)

// GoにはJavaのような例外処理がない。例外を投げない。
// その代わり、panicとrecoverを使う。
// これは最後の手段として使う。
// これはコードにはあってはならないか、もしくはpanicを極力減らす。

// Panic
// ビルトイン関数。
// オリジナルの処理フローを中断させることができる。
// パニックが発生するフローの中に入って関数Fがpanicをコールする。
// このプロセスは継続して実行される。
// 一旦panicのgoroutineが発生すると、コールされた関数がすべて返る。
// この時プログラムを抜ける。
// パニックは直接panicをコールする。実行時にエラーを発生させてもかまわない。
// 例えば配列の境界を超えてアクセスするなど。

// Recover
// ビルトイン関数。
// パニックを発生させるフローのgoroutineを復元することができる。
// recoverは遅延関数の中でのみ有効。
// 通常の実行中、recoverをコールするとnilが返る。
// 他には何の効果もない。もし現在のgoroutineがパニックに陥ったらrecoverをコールして、panicの入力値を補正し、正常な実行に復元することができる。

var user = os.Getenv("USER")

// panicの使用例
func panictest() {
	if user == "" {
		panic("no value for $USER")
	}
}

// 引数となっている関数が実行時にpanicを発生するか検査する
func throwsPanic(f func()) (b bool) {
	defer func() {
		if x := recover(); x != nil {
			b = true
		}
	}()
	f() // 関数fを実行する。もしfの中でpanicが出現したら、復元を行うことができる
	return
}

func main() {
	test := throwsPanic(panictest)
	fmt.Println("throwsPanic = ", test)
	panictest()
}
