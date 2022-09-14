use toy_vec::ToyVec;


fn main() {
    //let e: Option<&String>;
    //{
        let mut v = ToyVec::new();
        v.push("Java Finch".to_string());       // 桜文鳥
        v.push("Budgerigar".to_string());       // セキセイインコ
        let e = v.get(1);
        //e = v.get(1);   // ここでvがスコープから抜け、ToyVec構造体が破棄される
    //}
    // eは解放後のメモリを参照している
    assert_eq!(e, Some(&"Budgerigar".to_string()));

    // 'staticライフタイム
    static I0: i32 = 42;        // static変数。'staticスコープを持つ

    let mut s0: &'static str;
    let s1 = "42";              // &str型。文字列リテラルへの参照(データは静的領域にある)
    let s2 = 42.to_string();    // String型(データはヒープ領域にある)
    s0 = s1;                    // 文字列リテラルへの参照は'staticライフタイムを持つ
    //s0 = &s2;                   // コンパイルエラー。String型から&'static strは作れない

    let s1 = "42";              // &'static str型
    let s2 = 42.to_string();    // String型

    take_static(s1);            // &'static str型。OK
    //take_static(&s2);           // &String型。コンパイルエラー('static要求を満たせない)
    take_static(s2);            // String型。OK


    // 可変の参照と不正なポインタの回避
    let mut v: ToyVec<usize> = ToyVec::new();
    v.push(100);
    let e = v.get(0);       // 不変の参照(不変の借用)を取得
    // v.push(200);            // ベクタを変更する(pushは可変の参照をとる)
    assert_eq!(e, Some(&100));
    // v.push(200)により、キャパシティが不足し、growメソッドによってBox<[usize]>が再作成される。
    // 元のusizeの値があった領域は開放されるため、eの持つ参照はダングリングポインタになる。

}

// この関数は'staticライフタイムを持つ任意の型を引数にとる
fn take_static<T: 'static>(_x: T) { }
