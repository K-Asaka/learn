package main

// goroutineはGoのマルチスレッドのコア。
// goroutineは、最初から最後までスレッド。
// しかし、スレッドよりも小さく、十数個のgoroutineは底レイヤーで5、6個のスレッドを実現しているだけ。
// Go言語の内部では、これらのgoroutineの間ではメモリの共有を実現している。
// goroutineを実行するには少ないスタックメモリ(大体4〜5KB)を必要とするだけ。
// 当然対応するデータによって伸縮はするが、まさにこのためいくつものマルチスレッドタスクを実行できる。
// goroutineはthreadに比べて使いやすく、効果的。

// goroutineはGoのruntime管理を利用したスレッドコントローラ。
// goroutineはgoキーワードによって実現する。実は単なる普通の関数。
//
// go hello(a, b, c)
//
// キーワードgoを通じてgoroutineを起動する。

import (
	"fmt"
	"runtime"
)

func say(s string) {
	for i := 0; i < 5; i++ {
		runtime.Gosched()
		fmt.Println(s)
	}
}

func main() {
	go say("world") // 新しいGoroutinesを実行する
	say("hello")    // 現在のGoroutines実行
}

// 上の複数のgoroutineは同じプロセスで実行されている。
// runtime.Gosched()ではCPUの時間を他の人に受け渡す。
// 次にある段階で継続してこのgoroutineを実行する。
// デフォルトでは、ディスパッチャはプロセスを使うのみで、マルチスレッドを実現するだけ。
// マルチコアプロセッサのマルチスレッドを実現したい場合は、runtime.GOMAXPROCS(n)をコールすることで
// ディスパッチャに同時に複数のプロセスを使用させる必要がある。
// GOMAXPROCSは同時に実行するロジックコードのシステムプロセスの最大数を設定し、前の設定を返す。
// もしn < 1であった場合、現在の設定は変更されない。
// Goの新しいバージョンでディスパッチャが修正されれば、これは削除されるだろう。
// Robによるマルチスレッドの開発については
// http://concur.rspace.googlecode.com/hg/talk/concur.html#landing-slide
