package main

import (
	"fmt"
	"time"
)

func main() {
	bf_t := time.Now()
	for n := 1; n <= 100; n++ {
		if n % 15 == 0 {
			fmt.Println("Fizz Buzz!")
		} else if n % 5 == 0 {
			fmt.Println("Buzz!")
		} else if n % 3 == 0 {
			fmt.Println("Fizz!")
		} else {
			fmt.Println(n)
		}
	}
	af_t := time.Now()
	fmt.Println(af_t.Sub(bf_t))
}
