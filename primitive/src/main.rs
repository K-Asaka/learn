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

// この関数は引数を2倍した値を返す
fn double(n: i32) -> i32 {
    n + n
}

// この関数は引数の絶対値を返す
fn abs(n: i32) -> i32 {
    if n >= 0 { n } else { -n }
}

// この関数は&[char]型のスライスを引数に取り、その情報を表示する
fn print_info(name: &str, sl: &[char]) {
    println!("  {:9} - {}, {:?}, {:?}, {:?}",
            name,
        sl.len(),       // 長さ(バイト数)   usize型
        sl.first(),     // 最初の要素       Option<char>型
        sl[1],          // 2番目の要素      char型
        sl.last()       // 最後の要素       Option<char>型
    );
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

    let c1 = 'A';   // char型
    // '&'で参照を作り、型強制で生ポインタに変換する
    let c1_ptr: *const char = &c1;  // *const char型。不変の生ポインタ
    // 生ポインタの参照外しはunsafeな操作
    assert_eq!(unsafe { *c1_ptr }, 'A');

    let mut n1 = 0;     // i32型
    let n1_ptr: *mut i32 = &mut n1; // *mut i32型。可変の生ポインタ
    assert_eq!(unsafe { *n1_ptr }, 0);

    // 可変の生ポインタでは参照先の値を変更できる
    unsafe {
        *n1_ptr = 1_000;
        assert_eq!(*n1_ptr, 1_000);
    }

    // 変数に型注釈として関数ポインタ型を指定することで、関数名から関数ポインタを得られる
    let mut f: fn(i32) -> i32 = double;
    assert_eq!(f(-42), -84);    // double関数で2倍された

    // 関数ポインタのサイズはusizeと同じ(x86_64アーキテクチャなら8バイト)
    assert_eq!(std::mem::size_of_val(&f), std::mem::size_of::<usize>());

    f = abs;
    assert_eq!(f(-42), 42);     // abs関数で絶対値を得た


    let x = 4;      // 変数xを4に束縛する

    // クロージャを定義する。するとxがクロージャの環境に補足される(キャプチャされる)
    let adder = |n| n + x;
    assert_eq!(adder(2), 4 + 2);

    let mut state = false;
    // 別のクロージャを定義する。このクロージャは引数を取らない
    let mut flipflop = || {
        // stateが補足される
        state = !state;     // 状態を反転する
        state
    };

    // クロージャを呼ぶたびに返る値が反転する
    assert!(flipflop());        // true
    assert!(!flipflop());       // false
    assert!(flipflop());        // true

    // クロージャが返す値だけでなく、stateの値も変化している
    assert!(state);             // true

    // 環境になにも補足しないクロージャは関数ポインタ型になれる
    let mut f: fn(i32) -> i32 = |n| n * 3;
    assert_eq!(f(-42), -126);

    // 環境になにかを補足するクロージャは関数ポインタ型になれない
    // let x = 4;
    // f = |n| n * x;


    let t1 = (88, true);
    // フィールド0の要素(左から数えて最初の要素)を取り出す
    assert_eq!(t1.0, 88);

    // フィールド1の要素(2番目の要素)を取り出す
    assert_eq!(t1.1, true);

    // フィールド名にはコンパイル時の定数のみ使える。変数は不可
    // let i = 0;
    // let t1a = t1.i; // エラー

    // 要素を書き換えるので、変数t1にmutを付けて可変にする
    let mut t1 = (88, true);

    // フィールド0の要素を書き換える
    t1.0 += 100;    // 現在の値に100を足す

    assert_eq!(t1, (188, true));

    let (n1, b1) = (88, true);
    assert_eq!(n1, 88);
    assert_eq!(b1, true);

    let ((x1, y1), (x2, y2)) = ((0, 5), (10, -1));
    assert_eq!(x1, 0);
    assert_eq!(y1, 5);
    assert_eq!(x2, 10);
    assert_eq!(y2, -1);

    // 不要な値はアンダースコアを使うと無視できる
    let ((x1, y1), _) = ((0, 5), (10, -1));

    // 要素を書き換えるので、変数t1にmutを付けて可変にする
    let mut t1 = ((0, 5), (10, -1));

    // 要素を指す可変の参照を得るためにref mutを追加する
    let ((ref mut x1_ptr, ref mut y1_ptr), _) = t1;

    // *を付けることでポインタが指すアドレスにあるデータにアクセスできる
    *x1_ptr += 3;
    *y1_ptr *= -1;

    assert_eq!(t1, ((3, -5), (10, -1)));


    let a1 = [false, true, false];  // [bool; 3]型
    let a2 = [0.0, -1.0, 1.0, 0.5];                 // [f64; 4]型

    // `len()`で配列の長さを得られる
    assert_eq!(a2.len(), 4);

    // 長さ100の配列を作り、全要素を0i32で初期化する
    // (要素の型はCopyトレイトを実装していなければならない)
    let a3 = [0; 100];      // [i32; 100]型
    assert_eq!(a3.len(), 100);

    // 配列は入れ子にできる
    let a4 = [['a', 'b'], ['c', 'd']];     // [[char; 2]; 2]型。2次元配列

    // 配列は同じ型の要素の並び。異なる型の要素は持てない
    // let a5 = [false, 'a'];

    // 配列の長さは実行時に指定できない
    let size = 100;
    // let a1 = [0; size];  // コンパイルエラー

    // ベクタなら実行時に長さを指定できる
    let mut v1 = vec![0; size];   // Vec<i32>型
    assert_eq!(v1.len(), 100);              // 長さは100

    // ベクタには要素を追加したり、削除したりできる
    v1.push(1);                     // ベクタの最後尾に要素を追加する
    assert_eq!(v1.len(), 101);      // 長さは101になる
    assert_eq!(v1.pop(), Some(1));  // ベクタの最後尾から要素を取り除く
    assert_eq!(v1.len(), 100);      // 長さは100に戻る


    let array1 = ['H', 'e', 'l', 'l', 'o'];
    assert_eq!(array1[1], 'e');

    let mut array2 = [0, 1, 2];
    array2[1] = 10;
    assert_eq!(array2, [0, 10, 2]);

    // インデックスは定数でなくてもかまわない
    let mut index = 0;
    assert_eq!(array2[index], 0);
    index += 1;
    assert_eq!(array2[index], 10);

    let array3 = [0, 1];
    // println!(array3[2]);    // エラー。インデックスが範囲外
    // let index = 2;
    // println!("{}", array3[index]); // コンパイルエラーにならず、実行時にパニックする

    assert_eq!(array3.get(1), Some(&1));    // get()はインデックスが範囲内の時はSome(&値)を返す
    assert_eq!(array3.get(2), None);        // さもなければNoneを返す


    let array4 = ['a'; 50];     // 長さ50

    // iter()で要素が不変のイテレーターを作成
    for ch in array4.iter() {
        print!("{},", *ch);
    }

    let mut array5 = [1; 50];      // 長さ50
    // iter_mut()で要素が可変のイテレータを作成
    for n in array5.iter_mut() {
        *n *= 2;
    }
    

    // 配列
    let a1 = ['a', 'b', 'c', 'd'];  // 参照元のデータ。[char; 4]型
    println!("a1: {:?}", a1);

    print_info("&a1[..]", &a1[..]); // &[char]型。全要素のスライス
    print_info("&a1",     &a1);     // 同上
    print_info("%a1[1..3]", &a1[1..3]); // bとcを要素とする長さ2のスライス


    // ベクタ
    let v1 = vec!['e', 'f', 'g', 'h'];  // 参照元のデータ。Vec<char>型
    println!("\nv1: {:?}", v1);

    print_info("&v1[..]", &v1[..]);     // &[char]型。全要素のスライス
    print_info("&v1", &v1);             // 同上
    print_info("&v1[1..3]", &v1[1..3]);     // &[char]型。fとgを要素とする長さ2のスライス


    let mut a1 = [5, 4, 3, 2];    // 配列。[i32; 4]型
    let s1 = &mut a1[1..3];     // 可変のスライス。&mut[i32]型
    s1[0] = 6;                              // スライスの最初の要素を6にする
    s1[1] *= 10;                            // 2番目の要素を10倍する
    s1.swap(0, 1);                     // 要素を交換する
    assert_eq!(s1, [30, 6]);                // スライスの内容を確認

    // 参照元の配列の内容を確認
    assert_eq!(a1, [5, 30, 6, 2]);          // スライスを通じて配列の内容が変更された

    
    let a2: [i32; 0] = [];
    let s2 = &a2;                // 不変のスライスを作成
    assert!(s2.is_empty());                 // 空のスライス
    assert_eq!(s2.len(), 0);                // 長さは0
    assert_eq!(s2.first(), None);           // 最初の要素は存在しない

    let a3 = ["zero", "one", "two", "three", "four"];
    let s3 = &a3[1..4];            // 不変のスライスを作成
    assert!(!s3.is_empty());                // 空ではない
    assert_eq!(s3.len(), 3);                // 長さは3
    assert_eq!(s3.first(), Some(&"one"));   // 最初の要素

    assert_eq!(s3[1], "two");               // 2番目の要素
    // assert_eq!(s3[3], "?");              // 4番目の要素。存在しないのでpanicする
    assert_eq!(s3.get(1), Some(&"two"));    // 2番目の要素を得る別の方法
    assert_eq!(s3.get(3), None);            // 4番目の要素。存在しないのでNone

    assert!(s3.contains(&"two"));           // "two"を要素に持つ
    assert!(s3.starts_with(&["one", "two"]));   // "one", "two"で始まる
    assert!(s3.ends_with(&["two", "three"]));   // "two", "three"で終わる

    let mut a4 = [6, 4, 2, 8, 0, 9, 4, 3 ,7, 5, 1, 7];

    // 一部の要素を昇順にソートする
    &mut a4[2..6].sort();
    assert_eq!(&a4[2..6], &[0, 2, 8, 9]);

    // スライスを2つの可変スライスへ分割する
    let (s4a, s4b) = &mut a4.split_at_mut(5);

    // 前半を逆順にする
    s4a.reverse();
    assert_eq!(s4a, &[8, 2, 0, 4, 6]);

    // 後半を昇順にソートする
    s4b.sort_unstable();
    assert_eq!(s4b, &[1, 3, 4, 5, 7, 7, 9]);

    // sort()とsort_unstable()の違い
    // sort()は安定ソートなので同順なデータのソート前の順序がソート後も保存される
    // sort_unstable()は安定ソートではないが、一般的にsort()より高速

    // &mutを省略しても結果は同じ。型強制によって自動的にスライスが作られる
    a4[2..6].sort();
    let (s4a, s4b) = a4.split_at_mut(5);

    






}
