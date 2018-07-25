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

import (
	"fmt"
	"time"
)

func fibonacci(n int, c chan int) {
	x, y := 1, 1
	for i := 0; i < n; i++ {
		c <- x
		x, y = y, x+y
	}
	close(c)
}

func fibonacci2(c, quit chan int) {
	// Select
	// 複数のchannelが存在する場合、selectを通してchannel上のデータを監視することができる。
	// selectはデフォルトでブロックされる。
	// channelの中でやりとりされるデータを監視する時のみ実行する。
	// 複数のchannelの準備が整った時に、selectはランダムにひとつ選択し実行する。
	x, y := 1, 1
	for {
		select {
		case c <- x:
			x, y = y, x+y
		case <-quit:
			fmt.Println("quit")
			return
		default:
			fmt.Println("xがブロックされた")
		}
	}
	// selectの中にもdefault文がある。selectはswitchの機能によく似ている。
	// defaultは監視しているchannelがどれも準備が整っていない時に、デフォルトで実行される。
	// (selectはchannelを待ってブロックしない)
}

func main() {
	c := make(chan int, 2) // 2を1に修正するとエラーが発生する。2を3に修正すると正常に実行される
	c <- 1
	c <- 2
	fmt.Println(<-c)
	fmt.Println(<-c)
	// 上の例では、2回cの値を読み込む必要がある。これではあまり便利では無い。
	// Goはこの点を考慮し、rangeによってsliceやmapを操作するのと同じ感覚でバッファリング型のchannelを操作することができる。
	c1 := make(chan int, 10)
	go fibonacci(cap(c1), c1)
	for i := range c1 {
		fmt.Println(i)
	}
	// for i := range c1でこのchannelがクローズを明示されるまで連続してchannelの中のデータを
	// 読み込むことができる。上のコードでchannelのクローズが明示されているのが確認できる。
	// 生産者はcloseビルトイン関数によってchannelを閉じる。channelを閉じた後はいかなるデータも送信することはできない。
	// 消費側は、v, ok := <-chという式でchannelがすでに閉じられているかテストすることができる。
	// もしokにfalseが返ってきたら、channelはすでにどのようなデータも無く、閉じらてていることになる。
	// 生産者でchannelが閉じられる。消費側ではない。これは容易にpanicを引き起こす
	// また、channelはファイルのようなものではない。
	// 頻繁に閉じる必要はない。何のデータも送ることが無い場合はrangeループを終了させたい場合などで良い。

	// Select
	c2 := make(chan int)
	quit := make(chan int)
	go func() {
		for i := 0; i < 10; i++ {
			fmt.Println(<-c2)
		}
		quit <- 0
	}()
	fibonacci2(c2, quit)

	// タイムアウト
	// ときどきgoroutineがブロックされる状況に出くわす。
	// プログラム全体がブロックされる状況をどのように回避するのか。
	// selectを使ってタイムアウトを設定することができる。
	c3 := make(chan int)
	o := make(chan bool)
	go func() {
		for {
			select {
			case v := <-c3:
				println(v)
			case <-time.After(5 * time.Second):
				println("timeout")
				o <- true
				break
			}
		}
	}()
	<-o
}

// runtime goroutine
// runtimeパッケージにはgoroutineを処理するいくつかの関数が含まれる
// Goexit：事前に実行されたgoroutineから抜ける。ただし、defer関数は継続してコールされる
// Gosched：事前のgoroutineの実行権限をジェネレートする。ディスパッチャが他の待機中のタスクの実行を予定し、次のある時点でこの位置から実行を復元する
// NumCPU：CPUのコア数を返す
// NumGoroutien：現在実行しているgoroutineの総数を返す
// GOMAXPROCS：実行できるCPUコア数の最大値を設定し、前のコア数を返す
