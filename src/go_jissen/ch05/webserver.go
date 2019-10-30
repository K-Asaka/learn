package main

import (
	"html/template"
	"math/rand"
	"net/http"
	"time"
)

func process(w http.ResponseWriter, r *http.Request) {
	rand.Seed(time.Now().Unix())
	if rand.Intn(10) > 5 {
		t, _ := template.ParseFiles("src/go_jissen/ch05/layout.html", "src/go_jissen/ch05/red_hello.html")
		t.ExecuteTemplate(w, "layout", "")
	} else {
		t, _ := template.ParseFiles("src/go_jissen/ch05/layout.html", "src/go_jissen/ch05/blue_hello.html")
		t.ExecuteTemplate(w, "layout", "")
	}
}

func main() {
	server := http.Server{
		Addr: "127.0.0.1:8080",
	}
	http.HandleFunc("/process", process)
	server.ListenAndServe()
}
