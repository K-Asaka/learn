package main

/*
	現在のファイルがどのパッケージに属しているかを表す。
	mainパッケージは独立して実行できるパッケージ。コンパイル後、実行可能ファイルが生成される。
	mainパッケージには必ずインタフェースとなるmain関数が含まれる。main関数には、引数と戻り値はない。
	mainパッケージ以外は、*.aというファイルが生成され、$GOPATH/pkg/$GOOS_$GOARCHに出力される。
*/

// パッケージの導入
import (
	"fmt" // fmtパッケージ(システム固有)
)

// main関数
func main() {
	// fmtパッケージに定義されたPrintf関数をコールする
	// GoはUTF-8をサポートしているため、非ASCIIコードも直接出力できる
	fmt.Printf("Hello, world or 你好，世界 or καλημ ́ρα κóσμ or こんにちはせかい")
}
