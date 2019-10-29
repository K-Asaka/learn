package main

import (
	"fmt"
	"net/http"

	"github.com/julienschmidt/httprouter"
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

func hello(w http.ResponseWriter, r *http.Request, p httprouter.Params) {
	fmt.Fprintf(w, "hello, %s!\n", p.ByName("name"))
}

func main() {
	mux := httprouter.New()
	mux.GET("/hello/:name", hello)

	server := http.Server{
		Addr:    "127.0.0.1:8080",
		Handler: mux,
	}

	server.ListenAndServe()
}
