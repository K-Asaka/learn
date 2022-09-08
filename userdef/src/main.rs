// use std::collections::HashMap;

// // shapeモジュール内にPolygon構造体を定義
// // mod shape {
// //     #[derive(Default)]
// //     pub struct Polygon {            // この構造体にモジュール外からアクセスできるようになる
// //         pub vertexes: Vec<(i32, i32)>,
// //         pub stroke_width: u8,
// //         pub fill: (u8, u8, u8),
// //         internal_id: String,        // このフィールドだけはモジュール外からのアクセス不可
// //     }
// // }

// // shapeモジュールの外側でPolygonを使いたい
// // use shape::Polygon;  // pubが付いていないとコンパイルエラー

// // ライフタイム指定子('a)が必要
// struct StrRefs<'a> {
//     s1: &'a str,
//     s2: &'a str,
// }
// // もし指定しなかったらコンパイルエラーになる

// // ジェネリクスな関数の例
// pub fn sort<T: Ord>(x: &mut [T], up: bool) { }

// #[derive(Default)]
// pub struct Polygon<T> {
//     pub vertexes: Vec<T>,
//     // 他のフィールドは省略
// }

// // 座標
// trait Coordinates {}

// // デカルト座標
// #[derive(Default)]
// struct CartesianCoord {
//     x: f64,
//     y: f64,
// }
// impl Coordinates for CartesianCoord {}

// // 極座標
// #[derive(Default)]
// struct PolarCoord {
//     r: f64,
//     theta: f64,
// }
// impl Coordinates for PolarCoord {}


// type UserName = String;

// #[derive(Debug)]
// enum Task {
//     Open,
//     AssignedTo(UserName),
//     Working {
//         assignee: UserName,
//         remaining_hours: u16,
//     },
//     Done,
// }

// #[derive(Debug, PartialEq)]
// enum Weekday {
//     // Weekday型には以下のバリアントがある
//     Monday, Tuesday, Wednessday, Thursday, Friday,
// }

// // assert_eq!で使うためにDebugとPartialEqの実装が必要
// #[derive(Debug, PartialEq)]
// struct UniqueValue;



// // fn f1(name: &str) -> &str {
// fn f1(name: &str) -> String {
//     // let s =
//     format!("Hello, {}!", name)        // format!はStringを作る   
//     //;
//     // &s       // Stringから&strを作成し、戻り値として返す
// }

// fn add_elems(s: &[i32]) -> Option<i32> {
//     // 複数のOption値を扱うときは?演算子が便利
//     // Some(値)なら値を取り出し、Noneならこの関数からすぐに戻る(Noneを返す)
//     let s0 = s.get(0)?;
//     let s3 = s.get(3)?;
//     Some(s0 + s3)
// }

// // 複数のResult値を扱うときは?演算子が便利
// // Ok(値)なら値を取り出し、Err(エラーを表す値)ならこの関数からリターンする
// fn add0(s0: &str, s1: &str) -> Result<i32, std::num::ParseIntError> {
//     let s0 = s0.parse::<i32>()?;
//     let s1 = s1.parse::<i32>()?;
//     Ok(s0 + s1)
// }

// // map_err()コンビネータを使うとErr(エラーを表す値)のときに別のエラーに変換できる
// fn add1(s0: &str, s1: &str) -> Result<i32, String> {
//     let s0 = s0.parse::<i32>().map_err(|_e| "s0が整数ではありません")?;
//     let s1 = s1.parse::<i32>().map_err(|_e| "s1が整数ではありません")?;
//     Ok(s0 + s1)
// }

// fn main() {
//     let t1 = (3, "birds".to_string());      // (i32, String)型のタプル。スタックに置かれる
//     let mut b1 = Box::new(t1);              // Boxポインタを作る。タプルがヒープに移動する
//     (*b1).0 += 1;                           // *で参照外し
//     assert_eq!(*b1, (4, "birds".to_string()));

//     // Box::new()の実行後にt1にアクセスしようとするとコンパイルエラーになる
//     // println!("{:?}", &t1);   // error[E0382]:borrow of moved value: `t1`


//     let v1 = vec![false, true, false];      // Vec<bool>型
//     let v2 = vec![0.0, -1.0, 1.0, 0.5];     // Vec<f64>型

//     assert_eq!(v2.len(), 4);                // v2ベクタの長さは4

//     // 長さ100のベクタを作り、全要素を0i32で初期化する
//     // (要素の型はCloneトレイトを実装していなければならない)
//     let v3 = vec![0; 100];      // Vec<i32>型
//     assert_eq!(v3.len(), 100);

//     // ベクタは入れ子にできる。子の要素数はそれぞれが異なってもかまわない
//     let v4 = vec![vec!['a', 'b', 'c'], vec!['d']];      // Vec<Vec<char>>型

//     // ベクタは同じ型の要素の並び。異なる型の要素は持てない
//     // let v5 = vec![false, 'a'];

//     let mut v6 = vec!['a', 'b', 'c'];       // Vec<char>型
//     v6.push('d');                           // 最後尾に値を追加
//     v6.push('e');
//     assert_eq!(v6, ['a', 'b', 'c', 'd', 'e']);   // v6の現在の値

//     assert_eq!(v6.pop(), Some('e'));            // 最後尾から取り出し
//     v6.insert(1, 'f');                          // インデックス1の位置に要素を挿入
//     assert_eq!(v6.remove(2), 'b');              // インデックス2の要素を削除。戻り値は削除した値
//     assert_eq!(v6, ['a', 'f', 'c', 'd']);       // v6の現在の値

//     let mut v7 = vec!['g', 'h'];                // 別のベクタv7を作成
//     v6.append(&mut v7);                         // v6の最後尾にv7の全要素を追加
//     assert_eq!(v6, ['a', 'f', 'c', 'd', 'g', 'h']);
//     assert_eq!(v7, []);                         // v7は空になった(全要素がv6へ移動した)

//     let a8 = ['i', 'j'];                        // 配列a8を作成
//     v6.extend_from_slice(&a8);                  // v6の最後尾にa8の全要素を追加
//     assert_eq!(v6, ['a', 'f', 'c', 'd', 'g', 'h', 'i', 'j']);
//     assert_eq!(a8, ['i', 'j']);                 // a8は変更なし(a8の要素がコピーされた)

//     // 4要素のベクタVec<i32>を作り、要素を1つ足して5要素に拡張する
//     let mut v1 = vec![0, 1, 2, 3];
//     v1.push(4);
//     println!("v1 len: {}, capacity: {}", v1.len(), v1.capacity());
    
//     // Box<[i32]>に変換する。余分なメモリを持たなくするためにVecのshrink_to_fit()メソッドが実行されてからBox化される
//     let s1 = v1.into_boxed_slice();
//     // 余分なメモリを持っていないことを確認するためにVec<i32>に戻す
//     let v2 = s1.into_vec();
//     println!("v1 len: {}, capacity: {}", v2.len(), v2.capacity());

//     let mut m1 = HashMap::new();

//     // 要素を2つ追加する
//     m1.insert("a", 1);
//     m1.insert("b", 3);
//     assert_eq!(m1.len(), 2);        // 要素数は2

//     // キーに対応する値を取り出す
//     assert_eq!(m1.get("b"), Some(&3));
//     assert_eq!(m1.get("c"), None);  // キーが存在しないのでNone

//     // "d"が存在するならその値への参照を得る。存在しないなら"d"に対して0を登録してから参照を返す
//     let d = m1.entry("d").or_insert(0);
//     *d += 7;
//     assert_eq!(m1.get("d"), Some(&7));


//     let m2 = vec![("a", 1), ("b", 3)].into_iter().collect::<HashMap<_, _>>();
//     assert_eq!(m2.get("a"), Some(&1));
//     assert_eq!(m2.get("b"), Some(&3));


//     // strリテラルからStringを作る。どちらの方法でも結果は同じ
//     let mut s1 = "ラズベリー".to_string();
//     let mut s2 = String::from("ブラックベリー");

//     // Rust 1.19より前のバージョンでは性能上の理由からto_string()よりもto_owned()が推奨されていた
//     let s3 = "ストロベリー".to_owned();

//     s1.push_str("タルト");      // String型の文字列に&str型の文字列を追加
//     assert_eq!(s1, "ラズベリータルト");

//     s2.push('と');              // Stringにcharを追加する

//     // push_str()が受け付けるのは&str型のみ。以下はコンパイルエラー
//     //s2.push_str(s3);        // s3はString型

//     // &を付けると型強制というしくみによって&Stringから&strへ変換される
//     s2.push_str(&s3);
//     assert_eq!(s2, "ブラックベリーとストロベリー");


//     let i = 42;     // i32型
//     assert_eq!(i.to_string(), "42");

//     let f = 4.3 + 0.1;      // f64型
//     assert_eq!(f.to_string(), "4.3999999999999995");
//     assert_eq!(format!("{:.2}", f), "4.40");        // format!マクロが便利

//     let t = (1, "ABC");
//     // 2要素のタプル型はDebugトレイトを実装しているのでformat!マクロで変換できる
//     assert_eq!(format!("{:?}", t), r#"(1, "ABC")"#);


//     let s1 = "42";
//     assert_eq!(s1.parse::<i32>(), Ok(42));      // &str型からi32型へ変換

//     let s2 = "abc";
//     let r2: Result<f64, _> = s2.parse();        // 変数の型から型推論できるならparseの型パラメータは不要
//     assert!(r2.is_err());                       // 数値として解釈できないときはエラーが返る
//     println!("{:?}", r2);


//     let cs = ['t', 'r', 'u', 's', 't'];     // [char; 5]型
//     assert_eq!(cs.iter().collect::<String>(),       "trust");
//     assert_eq!(&cs[1..].iter().collect::<String>(), "rust" );


//     let bad_utf8: [u8; 7] = [
//         b'a',                   // a
//         0xf0, 0x90, 0x80,       // でたらめなバイト列
//         0xe3, 0x81, 0x82,       // あ
//     ];

//     // 不正なバイト列はUnicodeのU+FFFD Replacement Characterに置き換わる
//     let s = String::from_utf8_lossy(&bad_utf8);
//     assert_eq!(s, "a\u{fffd}あ");


//     println!("{}", f1("名前"));


//     let utf16: Vec<u16> = vec![0x61, 0x62, 0x6f22, 0x5b57];

//     // Vec<u16>の値をUTF-16と解釈しStringを作成する(UTF-8へ変換される)
//     if let Ok(s) = String::from_utf16(&utf16) {
//         assert_eq!(s, "ab漢字");
//     } else {
//         unreachable!();
//     }


//     // バイト文字列リテラル。ASCII文字以外のバイトは「\x2桁の16進数」で記述する
//     let bs1 = b"abc\xe3\x81\x82";       // &[u8; 6]型。UTF-8表現で"abcあ"
//     assert_eq!(bs1, &[b'a', b'b', b'c', 0xe3, 0x81, 0x82]);

//     // rawバイト文字列リテラル。エスケープ文字(\)を特別扱いしないので、\nは改行文字ではなく文字通り\nと解釈される
//     let bs2 = br#"ab\ncd"#;     // &[u8; 6]型
//     assert_eq!(bs2, &[b'a', b'b', b'\\', b'n', b'c', b'd']);

    
//     let a = ['a', 'b', 'c', 'd', 'e'];

//     // 糖衣構文と実際の範囲の対応
//     // assert_eq!(a[ ..  ], ['a', 'b', 'c', 'd', 'e']);
//     // assert_eq!(a[ .. 3], ['a', 'b', 'c'          ]);
//     // assert_eq!(a[ ..=3], ['a', 'b', 'c', 'd'     ]);
//     // assert_eq!(a[1..  ], [     'b', 'c', 'd', 'e']);
//     // assert_eq!(a[1.. 3], [     'b', 'c'          ]);
//     // assert_eq!(a[1..=3], [     'b', 'c', 'd'     ]);

//     // 糖衣構文とRange*型の対応
//     // assert_eq!(   ..   , std::ops::RangeFull                   );
//     // assert_eq!(   .. 3 , std::ops::RangeTo { end: 3 }          );
//     // assert_eq!(   ..=3 , std::ops::RangeToInclusive { end: 3 } );
//     // assert_eq!(  1..   , std::ops::RangeFrom { start: 1 }      );
//     // assert_eq!(  1.. 3 , std::ops::Range { start: 1, end: 3 }  );
//     // assert_eq!(  1..=3 , std::ops::RangeInclusive::new(1, 3)   );


//     let a1 = ['a', 'b', 'c', 'd'];
//     assert_eq!(a1.get(0), Some(&'a'));      // インデックス0は配列a1の範囲内なのでSome(&値)が返る
//     assert_eq!(a1.get(4), None);            // インデックス4は範囲外なのでNoneが返る

//     let mut o1 = Some(10);      // Option<i32>型
//     match o1 {                               // match式でバリアントが判別できる
//         Some(s) => assert_eq!(s, 10),   // パターンマッチで中の値を取り出す
//         None => unreachable!(),
//     }

//     o1 = Some(20);
//     if let Some(s) = o1 {                   // if let式でもバリアントの判別と値の取り出しができる
//         assert_eq!(s, 20);
//     }


//     let mut o2 = Some(String::from("Hello"));   // Option<String>型
//     assert_eq!(o2.unwrap(), "Hello");                           // unwrap()でSomeの中の値が取り出せる

//     // しかしunwrap()はNoneのときにpanicするので、できるだけ使わない方がいい
//     o2 = None;
//     //o2.unwrap();
//     // unwrap_or_else()ならNoneでもpanicしないので安心して使える
//     // Noneのときはクロージャを実行し、Noneの代わりになる値を得る
//     assert_eq!(o2.unwrap_or_else(|| String::from("o2 is none")), "o2 is none");


//     // Someで包まれた値を操作するならmap()やand_then()などのコンビネータが便利

//     // map()はSome(値)のときは値にクロージャを適用し、クロージャが返した値をSomeで包み直す
//     let mut o3 = Some(25);
//     assert_eq!(o3.map(|n| n * 10), Some(250));

//     // NoneならなにもせずNoneを返す
//     o3 = None;
//     assert_eq!(o3.map(|n| n * 10), None);

//     o3 = Some(10);
//     assert_eq!(
//         o3.map(|n| n * 10)
//         // and_then()はSome(値)のときは値にクロージャを適用し
//         // クロージャが返した値(Some(新しい値)、または、None)をそのまま返す
//         .and_then(|n| if n >= 200 { Some(n) } else { None }),
//         None
//     );

//     // インデックス0と3の両方に値があるので、それらの合計がSomeで包まれて返される
//     assert_eq!(add_elems(&[3, 7, 3, 127]), Some(3 + 127));

//     // インデックス3がないのでNoneが返される
//     assert_eq!(add_elems(&[7, 11]), None);


//     // str::parse()は文字列を指定した型(ここではi32型)に変換する
//     assert_eq!("10".parse::<i32>(), Ok(10));                        // 変換できたらOk(値)が返される
//     let res0 = "a".parse::<i32>();      // 変換できなかったら`Err(エラーを表す値)`が返される
//     assert!(res0.is_err());
//     println!("{:?}", res0);

//     assert_eq!(add0("3", "127"), Ok(3 + 127));
//     assert!(add0("3", "abc").is_err());


//     assert_eq!(add1("3", "abc"), Err("s1が整数ではありません".to_string()));


//     // type UserName = String;
//     // type Id = i64;
//     // type Timestamp = i64;
//     // type User = (Id, UserName, Timestamp);

//     // fn new_user(name: UserName, id: Id, created: Timestamp) -> User {
//     //     (id, name, created)
//     // }

//     // let id = 400;
//     // let now = 4567890123;
//     // let user = new_user(String::from("mika"), id, now);

//     // IdとTimestampは同じi64型なので、間違えてもエラーにならない
//     // let bad_user = new_user(String::from("kazuki"), now, id);   // nowとidが逆


//     use std::cell::RefCell;
//     // use std::collections::HashMap;
//     use std::rc::Rc;
//     pub type SharedMap<K, V> = Rc<RefCell<HashMap<K, V>>>;

//     // 標準ライブラリのstd::ioモジュールのソースコードより引用
//     // https://github.com/rust-lang/rust/blob/master/src/libstd/io/error.rs
//     //pub type Result<T> = result::Result<T, Error>;


//     // 名前付きフィールド構造体
//     // struct Polygon {
//     //     vertexes: Vec<(i32, i32)>,      // 頂点の座標
//     //     stroke_width: u8,               // 輪郭の太さ
//     //     fill: (u8, u8, u8),             // 塗りつぶしのRGB色
//     // }

//     // タプル構造体
//     struct Triangle(Vertex, Vertex, Vertex);
//     struct Vertex(i32, i32);

//     // ユニット構造体
//     // struct UniqueValue;
//     // または
//     // struct UniqueValue {}
//     // struct UniqueValue();


//     // Polygon型の値を作り、変数triangleを束縛する
//     // let triangle = Polygon {
//     //     vertexes: vec![(0, 0), (3, 0), (2, 2)],
//     //     fill: (255, 255, 255),
//     //     stroke_width: 1,
//     // };

//     // フィールド名と同じ名前の関数引数やローカル変数があるときは以下のような省略形も使える(Rust 1.17以降)
//     // fn new_polygon(vertexes: Vec<(i32, i32)>) -> Polygon {
//     //     let stroke_width = 1;
//     //     let fill = (0, 0, 0);
//     //     Polygon { vertexes, stroke_width, fill }
//     // }

//     // let quadrangle = new_polygon(vec![(5, 2), (4, 7), (10, 6), (8, 1)]);

//     // フィールド名でアクセス
//     // assert_eq!(triangle.vertexes[0], (0, 0));
//     // assert_eq!(triangle.vertexes.len(), 3);
//     // assert_eq!(triangle.fill, (255, 255, 255));

//     // パターンマッチでアクセス。不要なフィールドは..で省略できる
//     // let Polygon { vertexes: quad_vx, .. } = quadrangle;
//     // assert_eq!(4, quad_vx.len());

//     // :移行を省略すると、フィールドと同じ名前の変数が作られフィールド値に束縛される
//     // let Polygon { fill, .. } = quadrangle;
//     // assert_eq!((0, 0, 0), fill);

//     // 構造体の値を変更するにはmutが必要
//     // let mut polygon = new_polygon(vec![(-1, -5), (-4, 0)]);
//     // assert_eq!(polygon.vertexes.len(), 2);
//     // polygon.vertexes.push((2, 8));
//     // assert_eq!(polygon.vertexes.len(), 3);

//     // let triangle1 = Polygon {
//     //     vertexes: vec![(0, 0), (3, 0), (2, 2)],
//     //     fill: (255, 255, 255),
//     //     stroke_width: 5,
//     // };

//     // triangle1を元にvertexesだけ異なる新しい値を作る
//     // let triangle2 = Polygon {
//     //     vertexes: vec![(0, 0), (-3, 0), (-2, 2)],
//     //     .. triangle1
//     // };

//     // コンパイルエラーになる
//     // let bad_polygon = Polygon {
//     //     vertexes: vec![(0, 0), (3, 0), (2, 2)],
//     // };


//     // #[derive(Default)]
//     // struct Polygon {
//     //     vertexes: Vec<(i32, i32)>,
//     //     stroke_width: u8,
//     //     fill: (u8, u8, u8),
//     // }

//     // すべてのフィールドがデフォルト値を持つPolygonを作成する
//     // let polygon1: Polygon = Default::default();

//     // vertexesフィールドだけ別の値に設定し、他はデフォルト値にする
//     // let polygon2 = Polygon {
//     //     vertexes: vec![(0, 0), (3, 0), (2, 2)],
//     //     .. Default::default()
//     // };

//     // impl Default for Polygon {
//     //     fn default() -> Self {
//     //         Self {
//     //             stroke_width: 1,                // デフォルト値を1にする
//     //             vertexes: Default::default(),   // Vec<(i32, i32)>のDefault実装を使う
//     //             fill: Default::default(),       // (u8, u8, u8)のDefault実装を使う
//     //         }
//     //     }
//     // }

//     // let vx0 = Vertex(0, 0);
//     // let vx1 = Vertex(3, 0);
//     // let triangle = Triangle(vx0, vx1, Vertex(2, 2));

//     // assert_eq!((triangle.1).0, 3);

//     // struct UserName(String);
//     struct Id(u64);
//     struct Timestamp(u64);
//     // type User = (Id, UserName, Timestamp);

//     // fn new_user(name: UserName, id: Id, created: Timestamp) -> User {
//     //     (id, name, created)
//     // }

//     let id = Id(400);
//     let now = Timestamp(4567890123);

//     // nowとidの順番を間違えるとコンパイルエラーになってくれる
//     // let bad_user = new_user(UserName(String::from("kazuki")), now, id);




//     // フィールドないので作れる値は1つのみ
//     let uv1 = UniqueValue;
//     let uv2 = UniqueValue;
//     assert_eq!(uv1, uv2);


//     // 平日を表すWeekday型を定義する
//     // Debugトレイトを自動導出すると"{:?}"で表示できるようになる
//     // PartialEqトレイトを自動導出すると==演算子が使えるようになる


//     fn say_something(weekday: Weekday) {
//         if weekday == Weekday::Friday {
//             println!("TGIF!");      // Thank God, it's Friday (やっと金曜日だ)
//         } else {
//             println!("まだ{:?}か", weekday);
//         }
//     }

//     say_something(Weekday::Friday);

//     // 月を表すMonth型を定義する
//     enum Month {
//         // バリアントにisize型の整数値を割り当てられる
//         January = 1, February = 2, March = 3,   /* 中略 */ December = 12,
//     }

//     assert_eq!(3, Month::March as isize);       // isize型にキャストすると割り当てた値が得られる




//     // use宣言でTaskが持つバリアントをインポートするとバリアント名が直接書けるようになる
//     // use crate::Task::*;

//     // Task型の値を3つ作り、ベクタに格納する
//     let tasks = vec![
//         // もし上のuse宣言がなかったらTask::AssignedToと書かないといけない
//         AssignedTo(String::from("junko")),
//         Working {
//             assignee: String::from("hiro"),
//             remaining_hours: 18,
//         },
//         Done,
//     ];

//     // 個々のタスクの状況をレポートする
//     for (i, task) in tasks.iter().enumerate() {
//         // match式によるパターンマッチでバリアントを識別し、フィールド値を取り出す
//         match task {
//             AssignedTo(assignee) => {
//                 println!("タスク{}は{}さんにアサインされています", i, assignee)
//             }
//             Working { assignee, remaining_hours } => {
//                 println!("タスク{}は{}さんが作業中です。残り{}時間の見込み", i, assignee, remaining_hours)
//             }
//             _ => println!("タスク{}はその他のステータス({:?})です", i, task)
//         }
//     }


//     let vertexes = vec![
//         CartesianCoord {x:  0.0, y:  0.0},
//         CartesianCoord {x: 50.0, y:  0.0},
//         CartesianCoord {x: 30.0, y: 20.0}
//     ];
    
//     // Polygon<CartesianCoord>型
//     let poly = Polygon { vertexes, .. Default::default() };
    

//     #[derive(Default)]
//     struct A { f0: u8, f1: u32, f2: u8 }

//     let a: A = Default::default();
//     println!("struct A ({} bytes)\n  f0: {:p}\n  f1: {:p}\n  f2: {:p}\n",
//             std::mem::size_of::<A>(), &a.f0, &a.f1, &a.f2);

//     // #[repr(C)]アトリビュートを付けると構造体の内部表現がC言語の仕様通りになり、
//     // FFIで安全に受け渡せるようになる。

// }

fn main() {
    let i1 = 42;    // i32型
    let f1 = i1 as f64 / 2.5;   // i32型からf64型へキャスト
    println!("{}", f1);

    let c1 = 'a';
    assert_eq!(97, c1 as u32);      // char型からu32型へキャスト

    let i2 = 300;       // i32型
    let u1 = i2 as u8;  // u8型へキャスト

    // 300はu8型の最大値を超えているので桁あふれして44になる(300を256で割った余りは44)
    assert_eq!(44, u1);

    let t1 = ('a', 42);
    // let t2 = t1 as (u32, u8);    // エラー

    let v1 = vec![b'h', b'e', b'l', b'l', b'o'];    // Vec<u8>型
    // let v2 = v1 as Vec<u16>;    // エラー

    let t3 = (t1.0 as u32, t1.1 as u8);
    let v3 = v1.iter().map(|&n| n as u16).collect::<Vec<u16>>();

    // &str型はVec<u8>型への変換を対象としたFromトレイトを実装している
    let v4: Vec<u8> = From::from("hello");
    assert_eq!(v1, v4);


    let p1 = Box::new(10);      // Box<i32>型

    // boxポインタを生ポインタ*mut i32型に変換したいが型キャストできない
    // let p2 = p1 as *mut i32;     // エラー

    // Boxポインタと*mutポインタはどちらも同じビット幅なのでtransmuteできる
    let p3: *mut i32 = unsafe { std::mem::transmute(p1) };

    let f1 = 5.6789e+3_f32;     // 5678.9

    // f32型からi32型へキャストする。小数点以下は切り捨てられる
    let i1 = f1 as i32;
    println!("{}", i1);     // 5678と表示される

    // f32型からi32型へtransmuteする
    let i2: i32 = unsafe { std::mem::transmute(f1) };
    println!("{}", i2);     // 浮動小数点数を整数として再解釈した値1169258291が表示される
    

}