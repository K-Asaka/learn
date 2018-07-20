package main

import "fmt"

// WHITE 白, BLACK 黒, BLUE 青, RED 赤, YELLOW 黄
const (
	WHITE = iota
	BLACK
	BLUE
	RED
	YELLOW
)

// Color Color型(byte型のエイリアス)
type Color byte

// Box Box構造体
type Box struct {
	width, height, depth float64
	color                Color
}

// BoxList Box構造体のslice
type BoxList []Box // a slice of boxes

// Volume Boxの体積を返す
func (b Box) Volume() float64 {
	return b.width * b.height * b.depth
}

// SetColor Boxの色をcに変更する
func (b *Box) SetColor(c Color) {
	// Boxのポインタを使っている。
	// SetColorの目的はBoxの色を変えることだが、ポインタで渡さなければ
	// SetColorが受け取るのはBoxのコピーとなるため、BoxのColorを変更することができない。
	b.color = c
	// *b.color = cと書かなくて良い
	// bはBoxのポインタであることをGoはわかっている
	// メソッドのreceiverが*Tならば、T型のエンティティの変数V上でこのメソッドをコールすることができる。
	// &Vによってメソッドをコールする必要はない。
	// もし、メソッドのreceiverがTならば、T型の変数P上でこのメソッドをコールすることができる。
	// Pを使ってメソッドをコールする必要はない。
	// コールしているポインタのメソッドがポインタのメソッドであるかどうかは気にする必要がない。
}

// BiggestColor BoxListに定義されており、listの中の体積が最大の色を返す
func (bl BoxList) BiggestColor() Color {
	v := 0.00
	k := Color(WHITE)
	for _, b := range bl {
		if bv := b.Volume(); bv > v {
			v = bv
			k = b.color
		}
	}
	return k
}

// PaintItBlack BoxListのすべてのBoxの色を全部黒に変更する
func (bl BoxList) PaintItBlack() {
	for i, _ := range bl {
		bl[i].SetColor(BLACK)
		// SetColorにはBoxのポインタを渡すが、記述はこれでよい。
	}
}

// String Colorに定義されており、Colorの具体的な色を返す
func (c Color) String() string {
	strings := []string{"WHITE", "BLACK", "BLUE", "RED", "YELLOW"}
	return strings[c]
}

func main() {
	// カスタム定義型の確認コード
	// カスタム定義型を使うことで、自分のコードの中に意味のある型を定義することができる
	type ages int
	type money float32
	type months map[string]int
	m := months{
		"January":  31,
		"February": 28,
		"December": 31,
	}
	fmt.Println(m)

	boxes := BoxList{
		Box{4, 4, 4, RED},
		Box{10, 10, 1, YELLOW},
		Box{1, 1, 20, BLACK},
		Box{10, 10, 1, BLUE},
		Box{10, 30, 1, WHITE},
		Box{20, 20, 20, YELLOW},
	}

	fmt.Printf("We have %d boxes in our set\n", len(boxes))
	fmt.Println("The volume of the first one is ", boxes[0].Volume(), "cm³")
	fmt.Println("The color of the last one is ", boxes[len(boxes)-1].color.String())
	fmt.Println("The biggest one is ", boxes.BiggestColor().String())

	fmt.Println("Let's paint them all black")
	boxes.PaintItBlack()
	fmt.Println("The color of the second one is", boxes[1].color.String())
	fmt.Println("Obviously, now, the biggest one is", boxes.BiggestColor().String())

}
