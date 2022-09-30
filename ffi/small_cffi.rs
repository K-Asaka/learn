use std::os::raw::c_double;

// インポートするCの関数群はextern "C" { .. }で囲む
extern "C" {
    fn cos(x: c_double) -> c_double;
}

fn main() {
    // Cの関数はRustの管理下にないのですべてアンセーフとして扱われる
    unsafe {
        // Rustの関数のように呼び出せる
        println!("{}", cos(1.5));
    }
}
