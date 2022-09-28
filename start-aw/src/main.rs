use actix_web::{server, App, Error, FromRequest, HttpRequest, Path, Responder, State};
use serde_derive::*;

// Deserializeにしたがって抽出されるので型を用意しておく
#[derive(Deserialize)]
struct HelloPath {
    // {name}に対応するフィールドを定義する
    name: String,
}

// アプリケーション情報を保持するデータ型
struct MyApp {
    server_name: String,
}

// State<T>型の引数を取るとデータ型を受け取れる
fn hello_with_state(app: State<MyApp>) -> Result<String, Error> {
    Ok(format!("Hello from {}!", &app.server_name))
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
        // App::new()
        //     .resource("/", |r| r.f(hello))
        //     // .resource("/{name}", |r| r.f(hello))
        //     .resource("/{name}", |r| r.with(hello_name))
        App::with_state(MyApp {
            server_name: "server with state".into(),
        })
        .resource("/info", |r| r.with(hello_with_state))
        .resource("/{name}", |r| r.with(hello_name))
    })
    .bind("localhost:3000")
    .expect("Can not bind to port 3000")
    .run();
}
