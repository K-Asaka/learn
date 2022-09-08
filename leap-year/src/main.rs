// 第6章 基本構文
// 入力された年がうるう年かどうかを判断するプログラム

// std::io 名前空間を io としてインポート
use std::io;
// std::io::Write トレイトを使う
use std::io::Write;

// 例5
// struct Circle {
//     radius: u32,
// }
// impl Circle {
//     fn diameter(&self) -> u32 {
//         self.radius * 2
//     }
// }

// 例6
struct Circle {
    radius: u32,
}

impl Circle {
    // Circle::diameterメソッド
    fn diameter(&self) -> u32 {
        self.radius * 2
    }

    // small_circle関連関数
    fn small_circle() -> Circle {
        Circle { radius: 1 }
    }
}

// エントリポイントとなる関数
fn main() {
    let mut year = String::new();
    print!("Please input a year to check if it is a leap year: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut year).unwrap();
    let year = year.trim().parse::<u32>().unwrap();

    if is_leap_year(year) {
        println!("{} is a leap year!", year);
    } else {
        println!("{} is not a leap year.", year);
    }

    let circle1 = Circle { radius: 10 };
    println!("Circle1's diameter: {}", circle1.diameter());


    // Circleの関連関数small_circleの呼び出し
    let circle1 = Circle::small_circle();
    println!("Circle1's diameter: {}", circle1.diameter());

    // 例1
    let date_string = "2019-01-06";     // 型を省略できる
    let pi: f64 = 3.14;                 // 型を明示してもよい
    let not_initialized;                // 初期化しなくてもよい
    let (a, b) = (19, 79);              // パターンは単なる変数ではない

    not_initialized = 1;


    // 例2
    let mut mutable_string = String::from("String");    // 文字列に束縛
    mutable_string = String::from("Hello");             // 別の文字列に束縛
    mutable_string.push_str(", world!");                // 文字列を変更する操作
    // mutable_string = 2019;                              // エラー！異なる型の値に束縛し直すことはできない



}

// うるう年の場合はtrue、平年の場合はfalseを返す関数
fn is_leap_year(year: u32) -> bool {
    year %4 == 0 && !(year % 100 == 0 && year % 400 != 0)
}

// 発散する関数(値を返さない関数)
fn end_function() -> ! {
    std::process::exit(0);
}

// 例3
fn scope_example() {
    let x = 10;

    if x == 10 {
        let y = 20;
        println!("{}", y);
    }

    {
        let z = 30;
    }

    println!("{}", x);
}

fn another_fn() {

}

fn shadowing_example() {
    let x = 10;
    let x = 20;
    let x = "String";

    println!("{}", x);

    {
        let x = 30;
        println!("{}", x);
    }

    println!("{}", x);
}