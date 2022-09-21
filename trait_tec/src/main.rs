// fn take_string(_s: String) {}
fn take_string(s: impl Into<String>) {
    let _s = s.into();
}

fn main() {
    // take_string("some_string");      // 文字列リテラルは渡せない
    // take_string("some_string".to_string());  // to_stringを呼ぶ必要がある
    // 文字列リテラルも渡せる
    take_string("some_string");
    // Stringも渡せる
    let arg = "string".to_string();
    take_string(arg.as_str());
}
