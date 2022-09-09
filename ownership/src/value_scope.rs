// 構造体を定義する
// println!の"{:?}"で表示できるようにDebugトレイトを自動導出しておく
#[derive(Debug)]
struct Parent(usize, Child, Child);     // Parentはusizeに加えてChildを2つ持つ

#[derive(Debug)]
struct Child(usize);

use std::ops::Drop;

// Parent構造体にデストラクタを実装する
impl Drop for Parent {
    fn drop(&mut self) {
        println!("Dropping {:?}", self);
    }
}

pub fn value_scope() {
    let p1 = Parent(1, Child(11), Child(12));
    {   // ブロックを作りp2はその中で導入する
        let p2 = Parent(2, Child(21), Child(22));
        println!("(a)  p1: {:?}, p2: {:?}", p1, p2);    // (a)の時点
    }

    println!("(b)  p1: {:?}", p1);                      // (b)の時点
    let p3 = Parent(3, Child(31), Child(32));
    println!("(c)  p1: {:?}, p3: {:?}", p1, p3);        // (c)の時点
}
