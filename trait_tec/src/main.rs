use std::fmt;

// fn take_string(_s: String) {}
fn take_string(s: impl Into<String>) {
    let _s = s.into();
}

// minとmaxをオプショナルにする
fn range(min: impl Into<Option<usize>>, max: impl Into<Option<usize>>) { }

#[derive(Debug)]
enum Either<A, B> {
    A(A),
    B(B),
}

impl<A, B> fmt::Display for Either<A, B>
where
    A: fmt::Display,
    B: fmt::Display,
{
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        match self {
            Either::A(a) => a.fmt(f),
            Either::B(b) => b.fmt(f),
        }
    }
}

fn main() {
    // take_string("some_string");      // 文字列リテラルは渡せない
    // take_string("some_string".to_string());  // to_stringを呼ぶ必要がある
    // 文字列リテラルも渡せる
    take_string("some_string");
    // Stringも渡せる
    let arg = "string".to_string();
    take_string(arg.as_str());

    // minには値を渡し、maxに渡さない場合
    range(1, None);

    // Vec<Either<bool, i32>>として宣言しておく
    let mut v: Vec<Either<bool, i32>> = vec![];
    // Eitherの値を入れる
    v.push(Either::A(true));
    v.push(Either::B(1i32));

    // すると `{}` で表示できる
    for e in v {
        println!("{}", e);
    }
}
