package main

func main() {
	i := 0
Here: // この行の最初の単語はコロンを最後に持ってくることでタグになる
	println(i)
	i++
	if i > 10000 {
		goto End
	}
	goto Here
End:
	println("End")
}
