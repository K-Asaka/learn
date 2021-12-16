mod integer;
mod overflow;
mod float;
mod character;


// 戻り値の型を省略。コンパイラは戻り値がユニット型だと解釈する
fn hello() {
    println!("Hello");    
}

// 関数f1は呼び出し元の値のコピーを引数nに束縛し、1に変更する
fn f1(mut n: u32) {
    n = 1;
    println!("f1:       n = {}", n);
}

// 関数f2は呼び出し元の値を指すポインタを受け取り、ポインタが指す場所に2を格納する
fn f2(n_ptr: &mut u32) {
    println!("f2:   n_ptr = {:p}", n_ptr);

    // *を付けると参照先にアクセスできる。これを参照外し(dereference)と呼ぶ
    *n_ptr = 2;
    println!("n:  *n_ptr = {}", *n_ptr);
}

fn main() {
    // 整数リテラル
    let n = 42;
    println!("{}", n);

    // 文字リテラル
    let c = 'R';
    println!("{}", c);

    // 関数を呼び出し、(ないはずの)戻り値に変数retを束縛する
    let ret = hello();
    // アサーションでretの値がユニット値と等しいことを検査する
    assert_eq!(ret, ());
    // size_of::<型>()は、その型の値がメモリ上で占める大きさをバイト数で返す
    println!("{}", std::mem::size_of::<()>());
    assert_eq!(std::mem::size_of::<()>(), 0);   // 0バイト

    let b1 = true;
    let b2 = !b1;   // false、否定
    println!("b2={}", b2);

    let n1 = 8;
    let n2 = 12;
    let b3 = n1 >= 10;  // false
    let b4 = n2 >= 10;  // true
    let b5 = b3 && b4;  // false、ショートサーキット論理積
    let b6 = b3 || b4;  // true、ショートサーキット論理和
    println!("b5={}", b5);
    println!("b6={}", b6);

    assert_eq!(std::mem::size_of::<bool>(), 1); // サイズは1バイト

    integer::int();
    overflow::overflow();
    float::float();
    character::character();


    let mut n = 0;
    println!("main:     n = {}", n);

    f1(n);
    println!("main:     n = {}", n);

    // `&mut n`でnの値を指す可変のポインタを作成する
    f2(&mut n);
    println!("main:     n = {}", n);

    let c1 = 'A';       // char型
    let c1_ptr = &c1;       // &char型。イミュータブルな参照(不変の参照)
    assert_eq!(*c1_ptr, 'A');

    let mut n1 = 0; // i32型
    let n1_ptr = &mut n1;   // &mut i32型。ミュータブルな参照(可変の参照)
    assert_eq!(*n1_ptr, 0);

    // 可変の参照では参照先の値を変更できる
    *n1_ptr = 1_000;
    assert_eq!(*n1_ptr, 1_000);

}
