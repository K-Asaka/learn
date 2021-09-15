use std::cmp::Ordering;

pub fn sort_by<T, F>(x: &mut [T], comparator: &F) -> Result<(), String>
    where F: Fn(&T, &T) -> Ordering
{
    if x.len().is_power_of_two() {
        do_sort(x, true, comparator);
        Ok(())
    } else {
        Err(format!("The length of x is not a power of two. (x.len(): {})", x.len()))
    }
}


use super::SortOrder;

pub fn sort<T: Ord>(x: &mut [T], order: &SortOrder) -> Result<(), String> {
    // do_sortを呼ぶ代わりに、sort_byを呼ぶようにする
    // is_power_of_twoはsort_byが呼ぶので、ここからは削除した
    match *order {
        // 昇順ならa.cmp(b)、降順ならb.cmp(a)を行う
        SortOrder::Ascending => sort_by(x, &|a, b| a.cmp(b)),
        SortOrder::Descending => sort_by(x, &|a, b| b.cmp(a)),
    }
}

fn do_sort<T, F>(x: &mut [T], forward: bool, comparator: &F) 
    where F: Fn(&T, &T) -> Ordering
{
    if x.len() > 1 {
        let mid_point = x.len() / 2;

        // xをバイトニックにソートする
        // 第2引数がtrueのときはcomparatorで示される順序でソート
        do_sort(&mut x[..mid_point], true, comparator);
        // 第2引数がfalseのときはcomparatorとは逆順でソート
        do_sort(&mut x[mid_point..], false, comparator);

        sub_sort(x, forward, comparator);
    }
}

fn sub_sort<T, F>(x: &mut [T], forward: bool, comparator: &F) 
    where F: Fn(&T, &T) -> Ordering
{
    if x.len() > 1 {
        compare_and_swap(x, forward, comparator);
        let mid_point = x.len() / 2;
        sub_sort(&mut x[..mid_point], forward, comparator);
        sub_sort(&mut x[mid_point..], forward, comparator);
    }
}

fn compare_and_swap<T, F>(x: &mut [T], forward: bool, comparator: &F)
    where F: Fn(&T, &T) -> Ordering
{
    // 比較に先立ちfoward(bool値)をOrdering値に変換しておく
    let swap_condition = if forward {
        Ordering::Greater
    } else {
        Ordering::Less
    };
    let mid_point = x.len() / 2;
    for i in 0..mid_point {
        // comparatorクロージャで2要素を比較し、返されたOrderingのバリアントが
        // swap_conditionと等しいなら要素を交換する
        if comparator(&x[i], &x[mid_point + i]) == swap_condition {
            x.swap(i, mid_point + i);
        }
    }
}


// このモジュールはcargo testを実行したときのみコンパイルされる
#[cfg(test)]
mod tests {
    use crate::utils::{new_u32_vec, is_sorted_ascending, is_sorted_descending};

    #[test]
    fn sort_u32_large() {
        {
            // 乱数で65,536要素のデータ列を作る(65,536は2の16乗)
            let mut x = new_u32_vec(65536);
            // 昇順にソートする
            assert_eq!(sort(&mut x, &Ascending), Ok(()));
            // ソート結果が正しいことを検証する
            assert!(is_sorted_ascending(&x));
        }
        {
            let mut x = new_u32_vec(65536);
            assert_eq!(sort(&mut x, &Descending), Ok(()));
            assert!(is_sorted_descending(&x));
        }
    }
    
    // 構造体Studentを定義する
    // 構造体は関連する値を1つにまとめたデータ構造。複数のデータフィールドを持つ
    // deriveアトリビュートを使い、DebugトレイトとPartialEqトレイトの実装を自動導出する
    #[derive(Debug, PartialEq)]
    struct Student {
        first_name: String,     // first_name(名前)フィールド。String型
        last_name: String,      // last_name(苗字)フィールド。String型
        age: u8,                // age(年齢)フィールド。u8型(8ビット符号なし整数)
    }

    // implブロックを使うと対象の型に関連関数やメソッドを実装できる
    impl Student {
        // 関連関数newを定義する
        fn new(first_name: &str, last_name: &str, age: u8) -> Self {
            // 構造体Studentを初期化して返す。Selfはimpl対象の型(Student)の別名
            Self {
                // to_stringメソッドで&str型の引数からString型の値を作る。
                first_name: first_name.to_string(),     // first_nameフィールドに値を設定
                last_name: last_name.to_string(),       // last_nameフィールドに値を設定
                age,        // ageフィールドにage変数の値を設定
                            // フィールドと変数が同じ名前のときは、このように省略形で書ける
            }
        }
    }

    // 親モジュール(first)のsort関数を使用する
    use super::{sort, sort_by};
    use super::SortOrder::*;
    
    #[test]
    // 年齢で昇順にソートする
    fn sort_students_by_age_ascending() {
        // 4人分のテストデータを作成
        let taro = Student::new("Taro", "Yamada", 16);
        let hanako = Student::new("Hanako", "Yamada", 14);
        let kyoko = Student::new("Kyoko", "Ito", 15);
        let ryosuke = Student::new("Ryosuke", "Hayashi", 17);

        // ソート対象のベクタを作成する
        let mut x = vec![&taro, &hanako, &kyoko, &ryosuke];

        // ソート後の期待値を作成する
        let expected = vec![&hanako, &kyoko, &taro, &ryosuke];

        assert_eq!(
            // sort_by関数でソートする。第2引数はソート順を決めるクロージャ
            // 引数に2つのStudent構造体をとり、ageフィールドの値をcmpメソッドで
            // 比較することで大小を決定する
            sort_by(&mut x, &|a, b| a.age.cmp(&b.age)),
            Ok(())
        );

        // 結果を検証する
        assert_eq!(x, expected);
    }

    #[test]
    fn sort_student_by_name_ascending() {
        let taro = Student::new("Taro", "Yamada", 16);
        let hanako = Student::new("Hanako", "Yamada", 14);
        let kyoko = Student::new("Kyoko", "Ito", 15);
        let ryosuke = Student::new("Ryosuke", "Hayashi", 17);

        let mut x = vec![&taro, &hanako, &kyoko, &ryosuke];
        let expected = vec![&ryosuke, &kyoko, &hanako, &taro];

        assert_eq!(sort_by(&mut x,
            // まずlast_nameを比較する
            &|a, b| a.last_name.cmp(&b.last_name)
                // もしlast_nameが等しくない(LessまたはGreater)ならそれを返す
                // last_nameが等しい(Equal)ならfirst_nameを比較する
                .then_with(|| a.first_name.cmp(&b.first_name))), Ok(())
        );
        assert_eq!(x, expected);
    }
}