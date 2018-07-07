package main

import (
	"flag"
	"fmt"
	"strconv"
	"time"
)

func main() {
	var n, m, max, count int64

	flag.Parse()
	args := flag.Args()
	if len(args) == 0 {
		fmt.Printf("No Argument")
		return
	}
	max, err := strconv.ParseInt(flag.Args()[0], 10, 64)
	if err != nil {
		if enum, ok := err.(*strconv.NumError); ok {
			switch enum.Err {
			case strconv.ErrRange:
				fmt.Printf("Bad Range Error")
			case strconv.ErrSyntax:
				fmt.Printf("Syntax Error")
			}
		}
		return
	}
	if max <= 0 {
		max = 1
	}
	fmt.Printf("%v 個目の素数: ", max)

	start := time.Now()
	count = 0
	for n = 2; ; n++ {
		flag := true
		for m = 2; m < n; m++ {
			if (n % m) == 0 {
				flag = false
				break
			}
		}
		if flag {
			count++
			if max <= count {
				fmt.Printf("%v", n)
				break
			}
		}
	}
	goal := time.Now()
	fmt.Printf("\n%v 経過", goal.Sub(start))
}
