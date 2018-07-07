package main

import (
	"fmt"
)

func main() {
	a := make([]int, 0)
	fmt.Printf("Slice(%02d) : %p : %v (%v)\n", 0, a, a, cap(a))
	for num := 1; num <= 17; num++ {
		a = append(a, num)
		fmt.Printf("Slice(%02d) : %p : %v (%v)\n", num, a, a, cap(a))
	}
}
