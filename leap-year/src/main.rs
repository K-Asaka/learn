// 第6章 基本構文
// 入力された年がうるう年かどうかを判断するプログラム
#![allow(overflowing_literals)]


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


// 例5
const SECRET_NUMBER: i32 = 25;
// 例6
static GLOBAL_COUNTER: i32 = 0;
// 例7
// 定義に使う値はコンパイル時に値が確定するものでないといけない
// static mut v: Option<Vec<i32>> = None;




// エントリポイントとなる関数
fn main() {
    // let mut year = String::new();
    // print!("Please input a year to check if it is a leap year: ");
    // io::stdout().flush().unwrap();
    // io::stdin().read_line(&mut year).unwrap();
    // let year = year.trim().parse::<u32>().unwrap();

    // if is_leap_year(year) {
    //     println!("{} is a leap year!", year);
    // } else {
    //     println!("{} is not a leap year.", year);
    // }

    // let circle1 = Circle { radius: 10 };
    // println!("Circle1's diameter: {}", circle1.diameter());


    // // Circleの関連関数small_circleの呼び出し
    // let circle1 = Circle::small_circle();
    // println!("Circle1's diameter: {}", circle1.diameter());

    // // 例1
    // let date_string = "2019-01-06";     // 型を省略できる
    // let pi: f64 = 3.14;                 // 型を明示してもよい
    // let not_initialized;                // 初期化しなくてもよい
    // let (a, b) = (19, 79);              // パターンは単なる変数ではない

    // not_initialized = 1;


    // // 例2
    // let mut mutable_string = String::from("String");    // 文字列に束縛
    // mutable_string = String::from("Hello");             // 別の文字列に束縛
    // mutable_string.push_str(", world!");                // 文字列を変更する操作
    // // mutable_string = 2019;                              // エラー！異なる型の値に束縛し直すことはできない


    // // ミュータブルなスタティック変数を扱うときは代入も参照もunsafeブロックの中で行わないといけない
    // unsafe {
    //     // 代入するときはコンパイル時に値が確定するものでなくてもよい
    //     v = Some(vec![1, 2, 3]);
    //     println!("{:?}", v);
    // }


    // 例1
    let answer1 = (10 + 20) * 30 / 4;
    println!("(10 + 20) x 30 / 4 = {}", answer1);

    // 例2
    // 数値リテラルについては、読みやすくするために好きな場所に_を入れることができる
    let mut answer2 = 5_000;
    answer2 += 600_000;
    println!("5000 + 600000 = {}", answer2);

    // エラーあり
    // let answer3 = 70 + 8.9;
    // println!("70 + 8.9 = {}", answer3);

    // 例4
    let answer4 = 70.0 + 8.9;
    println!("70.0 + 8.9 = {}", answer4);

    // 例5
    let answer5 = !((true || false) && false);
    println!("NOT ((true OR false) AND false) = {}", answer5);

    // 例6
    let answer6 = 0b11110000 & 0b01010000 | 0b00001010;
    // bは数値を2進数表記で出力するためのフォーマット文字列
    println!("11110000 & 01010000 | 00001010 = {:b}", answer6);

    // 例7
    let unsigned: u8 = 0b11111111;
    let signed: i8 = 0b11111111;
    println!("Unsigned right shift: {:08b}", unsigned >> 2);
    println!("Signed right shift: {:08b}", signed >> 2);

    
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
