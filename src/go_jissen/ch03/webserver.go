package main

import (
	"fmt"
	"net/http"
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

// HelloHandler HelloHandler
type HelloHandler struct{}

func (h HelloHandler) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello!")
}

func log(h http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		fmt.Printf("Handler called - %T\n", h)
		h.ServeHTTP(w, r)
	})
}

func protect(h http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		fmt.Printf("ユーザー権限確認")
		h.ServeHTTP(w, r)
	})
}

func main() {
	server := http.Server{
		Addr: "127.0.0.1:8080",
	}

	hello := HelloHandler{}
	http.Handle("/hello", protect(log(hello)))
	server.ListenAndServe()
}
