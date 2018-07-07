package main

import "fmt"

// カスタム定義型
type ages int
type money float32
type months map[string]int

// WHITE 白, BLACK 黒, BLUE 青, RED 赤, YELLOW 黄
const (
	WHITE = iota
	BLACK
	BLUE
	RED
	YELLOW
)

// Color Color型
type Color byte

// Box Box構造体
type Box struct {
	width, height, depth float64
	color                Color
}

// BoxList Box構造体のslice
type BoxList []Box // a slice of boxes

// Volume 体積
func (b Box) Volume() float64 {
	return b.width * b.height * b.depth
}

// SetColor 色設定
func (b *Box) SetColor(c Color) {
	b.color = c
}

// BiggestColor カラー情報
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

// PaintItBlack 黒色で塗りつぶす
func (bl BoxList) PaintItBlack() {
	for i, _ := range bl {
		bl[i].SetColor(BLACK)
	}
}

func (c Color) String() string {
	strings := []string{"WHITE", "BLACK", "BLUE", "RED", "YELLOW"}
	return strings[c]
}

func main() {
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
	fmt.Println("The volume of the first one is ", boxes[0].Volume(), "cm3")
	fmt.Println("The color of the last one is ", boxes[len(boxes)-1].color.String())
	fmt.Println("The biggest one is ", boxes.BiggestColor().String())

	fmt.Println("Let's paint them all black")
	boxes.PaintItBlack()
	fmt.Println("The color of the second one is", boxes[1].color.String())
	fmt.Println("Obviously, now, the biggest one is", boxes.BiggestColor().String())
}
