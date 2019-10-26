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

type MyHandler struct{}

func (h *MyHandler) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello World!")
}

func main() {
	handler := MyHandler{}
	server := http.Server{
		Addr:    "127.0.0.1:8080",
		Handler: &handler,
	}
	server.ListenAndServe()
}
