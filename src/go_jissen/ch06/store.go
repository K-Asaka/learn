package main

import (
	"fmt"

	"github.com/jmoiron/sqlx"
	_ "github.com/lib/pq"
)

var Db *sqlx.DB

func init() {
	var err error
	Db, err = sqlx.Open("postgres", "host=172.16.199.249 user=db dbname=db password=db sslmode=disable")
	if err != nil {
		panic(err)
	}
}

func GetPost(id int) (post Post, err error) {
	post = Post{}
	err = Db.QueryRowx("select id, content, author from posts where id = $1", id).StructScan(&post)
	if err != nil {
		return
	}
	return
}

func (post *Post) Create() (err error) {
	err = Db.QueryRow("insert into posts (content, author) values($1, $2) returning id", post.Content, post.AuthorName).Scan(&post.Id)
	return
}

type Post struct {
	Id         int
	Content    string
	AuthorName string `db:"author"`
}

func main() {
	post := Post{Content: "Hello World!", AuthorName: "Sau Sheong"}
	post.Create()
	fmt.Println(post)
	readPost := Post{}
	readPost, _ = GetPost(post.Id)
	fmt.Println(readPost)
}
