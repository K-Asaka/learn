// StringのCのNULL終端文字列に対応する型
use std::ffi::CString;
// strのCのnull終端文字列に対応する型
use std::ffi::CStr;
use std::os::raw::c_schar;

// readlineライブラリとリンクする
#[link(name = "readline")]
extern "C" {
    // Cの符号付きchar型をc_scharで表現している
    fn readline(prompt: *const c_schar) -> *mut c_schar;
}

fn main() {
    unsafe {
        // Rustの文字列をCの文字列に変換する
        // NULL終端するためにCStringを使う
        let prompt = CString::new("> ").unwrap();
        loop {
            // readlineを呼び、結果をCStrでラップする
            let input = CStr::from_ptr(readline(prompt.as_ptr()));
            // &CStrを&strに変換する。
            let input = input.to_str().expect("input contains invalid unicode");
            // 以後はRustの文字列なので自由に操作できる
            if input == "exit" {
                break;
            }
            println!("your input is {}", input);
        }
    }
}
