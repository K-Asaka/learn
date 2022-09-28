use actix_web::{server, App, Error, FromRequest, HttpRequest, Path, Responder};
use serde_derive::*;

// Deserializeにしたがって抽出されるので型を用意しておく
#[derive(Deserialize)]
struct HelloPath {
    // {name}に対応するフィールドを定義する
    name: String,
}

// fn hello_name(req: &HttpRequest) -> Result<String, Error> {
//     // FromRequest::extractでデータを抽出する
//     let to = Path::<HelloPath>::extract(req)?;
//     // Path<T>はDeref<Target=T>を実装しているのでそのままHelloPathのように扱える
//     Ok(format!("Hello {}!", &to.name))
// }
// 引数にエクストラクタを書くとフレームワークが勝手に抽出して渡してくれる
fn hello_name(to: Path<HelloPath>) -> impl Responder {
    format!("Hello {}!", &to.name)
}

fn hello(req: &HttpRequest) -> impl Responder {
    let to = req.match_info().get("name").unwrap_or("World");
    format!("Hello {}!", to)
}

fn main() {
    server::new(|| {
        App::new()
            .resource("/", |r| r.f(hello))
            // .resource("/{name}", |r| r.f(hello))
            .resource("/{name}", |r| r.with(hello_name))
    })
    .bind("localhost:3000")
    .expect("Can not bind to port 3000")
    .run();
}
