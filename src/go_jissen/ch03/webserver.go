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

type HelloHandler struct{}

func (h *HelloHandler) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello!")
}

type WorldHandler struct{}

func (h *WorldHandler) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "World!")
}

func main() {
	hello := HelloHandler{}
	world := WorldHandler{}
	server := http.Server{
		Addr: "127.0.0.1:8080",
	}

	http.Handle("/hello", &hello)
	http.Handle("/world", &world)

	server.ListenAndServe()
}
