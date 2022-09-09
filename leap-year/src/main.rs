// 第6章 基本構文
// 入力された年がうるう年かどうかを判断するプログラム
#![allow(overflowing_literals)]

// unused_importsリントチェックの結果を無視する
// unused_importsは使われていないクレートをインポートしていないかどうかのリントチェック
#[allow(unused_imports)]

// dead_codeリントチェックへの違反をエラーとして取り扱う
// dead_codeは使われていない、エクスポートもされていないコードがないかどうかのリントチェック
#[deny(dead_code)]


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


    // 例1
    let a = 11;

    if a % 2 == 0 {
        println!("{} is an even number", a);    // aが偶数の場合
    } else {
        println!("{} is an odd number", a);     // aが奇数の場合
    }

    // 例2
    let a = 12;

    let even_or_odd = if a % 2 == 0 {
        "an even"
    } else {
        "an odd"
    };

    println!("{} is {} number", a, even_or_odd);

    // 例3　エラーあり
    // let a = 13;
    // let result = if a % 2 == 0 {
    //     'E'     // char型
    // } else {
    //     "AN ODD"    // &str型
    // };

    // 例4
    let a = 14;
    if a % 2 == 0 {
        println!("{} is an even number", a);        // 文なので戻り値は{}
    }
    // false節はないが、false節の戻り値は()として取り扱われる
    // そのため、if式の戻り値は()


    // 例1
    let value = 100;
    match value {
        1 => println!("One"),
        10 => println!("Ten"),
        100 => println!("One hundred"),
        _ => println!("Something else"),
    }

    // 例2
    let number = 10;
    let string = match number {
        1 => "One",
        10 => "Ten",
        100 => "One hundred",
        _ => "Something else",
    };
    println!("{}", string);

    // 例3　エラーあり
    // let character = 'C';
    // let something = match character {
    //     'A' => "Apple",
    //     'B' => "Bear",
    //     'C' => "Computer",
    // };
    // println!("{}", something);

    // 例4
    let character = 'C';
    let something = match character {
        'A' => "Apple",
        'B' => "Bear",
        'C' => "Computer",
        _ => "Something else",
    };
    println!("{}", something);

    // 例5
    enum Light {
        Red,
        Yellow,
        Green,
    }

    let light = Light::Green;

    // すべての可能性を列挙しているのでワイルドカードパターンがなくてもエラーにならない
    let action = match light {
        Light::Red => "Stop",
        Light::Yellow => "Proceed with caution",
        Light::Green => "Go",
    };
    println!("Green: {}", action);

    // 例6
    let unknown = Some("Apple");
    let string = match unknown {
        Some(something) => String::from("Hi, ") + something,
        None => String::from("Nothing"),
    };
    println!("{}", string);

    // 例7
    let ten = 10;
    let ten_reference = &ten;

    match ten_reference {
        number => assert_eq!(&10, number),  // numberは参照
    };

    match ten_reference {
        &number => assert_eq!(10, number),  // numberは参照ではない
    };

    // 例8
    let number = 42;
    let string = match number {
        // パターンの連結
        1 | 2 | 3 => "One or two or three",
        // 範囲のパターン
        40 ..= 50 => "From 40 to 50",
        _ => "Something else",
    };
    println!("{}", string);

    // 例9
    let string = Some("This is a very long string");
    let message = match string {
        Some(s) if s.len() >= 10 => "Long string",
        Some(_) => "String",
        None => "Nothing",
    };
    println!("{}", message);


    // 例10
    let score = Some(100);
    if let Some(100) = score {
        println!("you got full marks!");
    } else {
        println!("You didn't get full marks.");
    }


    // 例1
    // loop {
    //     println!("Infinite loop!");
    // }

    // 例2
    let mut counter = 10;
    loop {
        println!("{}", counter);

        if counter == 0 {
            break;
        }

        counter -= 1;
    }

    // 例3
    let mut counter = 0;
    let ten = loop {
        if counter == 10 {
            break counter;
        }
        counter += 1;
    };
    println!("{}", ten);

    // 例4
    // loop {
    //     println!("This is executed");
    //     continue;
    //     println!("This is not executed");
    // }


    // 例5
    let mut counter = 0;
    while counter != 10 {
        println!("{}", counter);
        counter += 1;
    }


    // 例6
    let mut counter = Some(0);
    while let Some(i) = counter {
        if i == 10 {
            counter = None;
        } else {
            println!("{}", i);
            counter = Some(i + 1);
        }
    }


    // 例7
    let vector = vec!["Cyan", "Magenta", "Yellow", "Black"];
    for v in vector.iter() {
        println!("{}", v);
    }


    // 例1
    let one = 1;
    let plus_one = |x| {
        x + one
    };

    println!("10 + 1 = {}", plus_one(10));

    // 例2　エラーあり
    // let mut one = 1;
    // let plus_one = |x| {
    //     x + one
    // };
    // one += 1;
    // println!("10 + 1 = {}", plus_one(10));

    // 例3
    let mut one = 1;
    let plus_one = move |x| {
        x + one
    };
    one += 1;
    println!("10 + 1 = {}", plus_one(10));
    

    let some_point = Point {x: 10, y: 20, z: 0};
    // Debugトレイとのfmt関数が自動的に実装されているので、:?フォーマット文字列を使うことができる
    println!("Debug: {:?}", some_point);

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

// 対象となるアイテム宣言の前に書く方法
#[test]
fn test1() {
    // 本体は省略
}

// fn test2() { // エラーになった
//     // 対象となるアイテム宣言の中に書く方法
//     #![test]
//     // 本体は省略
// }

// // macrosモジュールに含まれるマクロを読み込む
// #[macro_use] mod macros;

// // 外部のクレートで定義されているマクロを読み込むには、単にuseキーワードを使えばよい
// // logクレートからdebugマクロ、errorマクロを読み込む
// use log::{debug, error};

// ターゲットのOSがUnix系の場合にだけコンパイルする
#[cfg(unix)]
fn something_for_unix() {
    // 本体は省略
}

// ターゲットのOSがWindowsの場合にだけコンパイルする
#[cfg(windows)]
fn something_for_windows() {
    // 本体は省略
}

// Rustコンパイラに--cfg allfnsオプションを渡したときだけコンパイルされる
#[cfg(allfns)]
fn rarely_used_fn() {
    // 本体は省略
}

// Rustコンパイラに--cfg color="blue"オプションを渡したときだけコンパイルされる
#[cfg(color = "blue")]
fn blue_fn() {
    // 本体は省略
}

// Point構造体にDebugトレイトが自動的に実装される
#[derive(Debug)]
struct Point {
    x: i32,
    y: i32,
    z: i32,
}
