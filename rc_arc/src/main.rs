use std::rc::Rc;
use std::cell::RefCell;

#[derive(Debug)]
struct Child(isize);

struct A {
    c: char,
    s: String,
}

struct B {
    c: char,
    s: RefCell<String>,     // StringをRefCellで包む
}

fn main() {
    let mut rc1 = Rc::new(Child(1));        // Rcポインタ経由でChild値をヒープ領域に格納する
    // strong_countでこのChild値の参照カウント(共同所有者の数)が得られる
    println!("(a) count: {}, rc1: {:?}", Rc::strong_count(&rc1), rc1);
    {
        let rc2 = Rc::clone(&rc1);      // cloneで共同所有者を作る。参照カウントが増える
        println!("(b) count: {}, rc1: {:?}, rc2: {:?}", Rc::strong_count(&rc1), rc1, rc2);
    }   // rc2がスコープを抜け、参照カウントが減る
    println!("(c) count: {}, rc1: {:?}", Rc::strong_count(&rc1), rc1);
    
    // 参照カウントが1のときは可変の参照が得られる。そうでないときはNoneが返る
    if let Some(child) = Rc::get_mut(&mut rc1) {
        child.0 += 1;
    }
    println!("(d) count: {}, rc1: {:?}", Rc::strong_count(&rc1), rc1);

    let weak = Rc::downgrade(&rc1); // Rc::downgradeでWeakポインタが得られる
    println!(
        "(e) count: {}, rc1: {:?}, weak: {:?}",
        Rc::strong_count(&rc1), // 参照カウントは1。Weakポインタはカウントされない
        rc1,
        weak,
    );

    // WeakをRcにアップグレードするとChild値にアクセスできる
    if let Some(rc3) = weak.upgrade() {
        println!(
            "(f) count: {}, rc1: {:?}, rc3: {:?}",
            Rc::strong_count(&rc1),
            rc1,
            rc3,
        );
    }

    // rc1をドロップする(スコープを抜けたのと同じ)参照カウントが0になりChildは破棄される
    std::mem::drop(rc1);
    println!("(g) count: 0, weak.upgrade(): {:?}", weak.upgrade());


    let a = A {c: 'a', s: "alex".to_string() };
    let r = &a;     // 不変の参照を作る
    //r.s.push('a');              // 不変の参照経由でフィールドを変更しようとするとコンパイルエラーになる

    let b = B {c: 'a', s: RefCell::new("alex".to_string()) };
    let rb = &b;
    rb.s.borrow_mut().push('a');        // フィールドsのデータに対する可変の参照をとる
    {
        let rbs = b.s.borrow();             // 不変の参照をとる
        assert_eq!(&*rbs, "alexa");

        // RefCellでは他の参照が有効な間に可変の参照をとろうとすると実行時にパニックする
        // b.s.borrow_mut();       // この時点で不変の参照rbsがまだ有効
        
        // try_borrow_mutならパニックせずErrを返してくれる
        assert!(b.s.try_borrow_mut().is_err());     // Errが返る
    }   // rbsはここでスコープを抜ける
    assert!(b.s.try_borrow_mut().is_ok());          // Okが返る

}
