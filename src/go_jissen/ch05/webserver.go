package main

import (
	"html/template"
	"net/http"
)

func process(w http.ResponseWriter, r *http.Request) {
	tmpl := `<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Go Web Programming</title>
</head>
<body>
	{{ . }}
</body>
</html>
`
	t := template.New("tmpl.html")
	t, _ = t.Parse(tmpl)
}

func main() {
	server := http.Server{
		Addr: "127.0.0.1:8080",
	}
	http.HandleFunc("/process", process)
	server.ListenAndServe()
}
