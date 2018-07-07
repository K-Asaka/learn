package main

import "fmt"

/*
	遅延(defer)文法
	関数の中でdefer文を複数追加することができる。
	関数が最後まで実行された時、このdefer文が逆順に実行される。
	最後にこの関数が返る。
	特に、リソースをオープンする操作を行っているようなとき、エラーの発生に対してロールバックし、必要なリソースをクローズする必要がある。
	さもなければ、リソースのリークを引き起こす。
	リソースを開く際の例。
	func ReadWrite() bool {
		file.Open("file")
		// 何かを行う
		if failureX {
			file.Close()
			return false
		}
		if failureY {
			file.Close()
			return false
		}
		file.Close()
		return true
	}
	このコードはとても多くの重複がある。
	deferはこの問題を解決する。
	deferの後に指定された関数が、関数を抜ける前にコールされる。
	func ReadWrite() bool {
		file.Open("file")
		defer file.Close()
		if failureX {
			return false
		}
		if failureY {
			return false
		}
		return true
	}
	もしdeferを多用する場合は、deferはLIFOモードが採用される。
*/
// deferの例
func main() {
	for i := 0; i < 5; i++ {
		defer fmt.Printf("%d ", i)
	}
}
