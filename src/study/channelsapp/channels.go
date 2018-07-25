package main

// channels
// goroutineは同じアドレス空間で実行される。
// そのため、共有されたメモリへのアクセスはかならず同期されていなければならない。
// goroutineの間では、Goの持つチャネルという通信機構を利用している。
// チャネルはUnix shellとの双方向パイプを作成する。
// これを通して値を送信したり受診することができる。
// これらの値は特定の型のみが許容される。チャネル型。
// channelを定義した場合、チャネルに送信する値の型も定義しなければならない。
// かならずmakeを使ってchannelを作成する。
// ci := make(chan int)
// cs := make(chan string)
// cf := make(chan interface{})
// channelは <- 演算子を使ってデータを送ったり受けたりする
// ch <- v		// vをchannel chに送る
// v := <-ch	// chの中からデータを受け取り、vに代入する

import "fmt"

func sum(a []int, c chan int) {
	total := 0
	for _, v := range a {
		total += v
	}
	c <- total // send total to c
}

func main() {
	a := []int{7, 2, 8, -9, 4, 0}

	c := make(chan int)
	go sum(a[:len(a)/2], c)
	go sum(a[len(a)/2:], c)
	x, y := <-c, <-c // receive from c

	fmt.Println(x, y, x+y)
}

// デフォルトでは、channelがやり取りするデータはブロックされている。
// もう片方が準備できていなければ、Goroutinesの同期はもっと簡単になる。
// lockを表示する必要はない。いわゆるブロックとは、もし(value := <-ch)を読み取った場合、
// これはブロックされる。データを受け取った段階で(ch<-5)を送信するいずれのものも
// データが読み込まれるまでブロックされる。
// バッファリングの無いchannelは複数のgoroutineの間で同期を行う非常に優れたツール。
