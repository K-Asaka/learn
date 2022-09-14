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

}
