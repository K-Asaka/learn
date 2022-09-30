use std::os::raw::{c_int, c_void};

// ownership.cで定義したCの関数をインポートする
#[link(name = "ownership", kind = "static")]
extern "C" {
    fn take_ownership(i: *const c_int, dtor: unsafe extern "C" fn(i: *mut c_int)) -> c_void;
}

// デストラクタ関数。Cに渡した所有権をRustに返してもらうためのもの
unsafe extern "C" fn drop_pointer(i: *mut c_int) {
    // ポインタからBoxに復元することで所有権を取り戻す
    Box::from_raw(i);
    // ここでBoxのライフタイムが尽きるので、メモリが開放される
}

fn main() {
    let i = Box::new(1);
    // C側に所有権を渡すのでinto_rawを使う
    unsafe { take_ownership(Box::into_raw(i), drop_pointer) };
}
