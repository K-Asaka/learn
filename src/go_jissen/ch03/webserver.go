package main

import (
	"fmt"
	"net/http"
	"reflect"
	"runtime"
)

// Server Server構造体
// type Server struct {
// 	Addr           string
// 	Handler        Handler
// 	ReadTimeout    time.Duration
// 	WriteTimeout   time.Duration
// 	MaxHeaderBytes int
// 	TLSConfig      *tls.Config
// 	TLSNextProto   map[string]func(*Server, *tls.Conn, Handler)
// 	ConnState      func(net.Conn, ConnState)
// 	ErrorLog       *log.Logger
// }

func hello(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello!")
}

func log(h http.HandlerFunc) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		name := runtime.FuncForPC(reflect.ValueOf(h).Pointer()).Name()
		fmt.Println("Handler function called - " + name)
		h(w, r)
	}
}

func main() {
	server := http.Server{
		Addr: "127.0.0.1:8080",
	}

	http.HandleFunc("/hello", log(hello))
	server.ListenAndServe()
}
