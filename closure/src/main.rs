// この関数はクロージャFとcharを引数に取る
// FはFnを実装し、引数にcharを取り、boolを返す
fn apply_fn<F>(f: &F, ch: char) where F: Fn(char) -> bool {
    assert!(f(ch));     // chにクロージャを適用する。trueが返されればOK
}

// この関数はFnMutを実装したクロージャFとcharを引数にとる(Fの関数シグネチャは上と同じ)
fn apply_fn_mut<F>(f: &mut F, ch: char) where F: FnMut(char) -> bool {
    assert!(f(ch));
}

// この関数はFnOnceを実装したクロージャFとcharを引数にとる(Fの関数シグネチャは上と同じ)
fn apply_fn_once<F>(f: F, ch: char) where F: FnOnce(char) -> bool {
    assert!(f(ch));
}


fn main() {
    let s1 = "read-only";
    let mut lookup = |ch| s1.find(ch).is_some();    // find(&self)は&strを読むだけ
    apply_fn(&lookup, 'r');
    apply_fn_mut(&mut lookup, 'o');                 // Fnを実装するクロージャはFnMutも実装する
    apply_fn_once(lookup, 'y');                     // FnMutを実装するクロージャはFnOnceも実装する
    assert_eq!(s1, "read-only");                    // 環境に取り込まれた文字列(&str型)は変更されてない

    let mut s2 = "append".to_string();
    let mut modify = |ch| {
        s2.push(ch);        // push(&mut self, char)はStringを可変の参照経由で変更する
        true
    };
    //apply_fn(&modify, 'e');           // Fnをとる関数はコンパイルエラーになる
    apply_fn_mut(&mut modify, 'e');     // FnMutをとる関数はOK
    apply_fn_once(modify, 'd');         // FnOnceをとる関数はOK
    assert_eq!(s2, "appended");         // 環境に取り込まれた文字列(String型)が変更された

    let s3 = "be converted".to_string();
    let mut consume = |ch| {
        let bytes = s3.into_bytes();        // into_bytes(self)はStringを消費する(所有権をとる)
        bytes.contains(&(ch as u8))
    };
    // apply_fn(&consume, 'b');             // Fnをとる関数はコンパイルエラー
    // apply_fn_mut(&mut consume, 'c');     // FnMutをとる関数もコンパイルエラー
    apply_fn_once(consume, 'd');            // FnOnceをとる関数ならOK
    // assert_eq!(s3, "error");                // s3はムーブ済み。コンパイルエラー

    // Fnトレイトを実装するクロージャを定義する
    let lookup = || assert!(s1.find('d').is_some());
    // クロージャをspawnに渡す。クロージャにmoveがないのでコンパイルエラーになる
    let handle = std::thread::spawn(lookup);

    let lookup = move || assert!(s1.find('d').is_some());
    let handle = std::thread::spawn(move || assert!(s1.find('d').is_some()));
    handle.join().expect("Failed to run thread.");

}
