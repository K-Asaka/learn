pub struct ToyVec<T> {
    elements: Box<[T]>,     // T型の要素を格納する領域。各要素はヒープ領域に置かれる
    len: usize,             // ベクタの長さ(現在の要素数)
}

// implブロック内に関連関数やメソッドを定義していく。トレイト境界としてDefaultを設定する
impl<T: Default> ToyVec<T> {

    // newはキャパシティ(容量)が0のToyVecを作る
    pub fn new() -> Self {
        Self::with_capacity(0)
    }

    // with_capacityは指定されたキャパシティを持つToyVecを作る
    pub fn with_capacity(capacity: usize) -> Self {
        Self {
            elements: Self::allocate_in_heap(capacity),
            len: 0,
        }
    }

    // T型の値がsize個格納できるBox<[T]>を返す
    fn allocate_in_heap(size: usize) -> Box<[T]> {
        std::iter::repeat_with(Default::default)
            .take(size)             // T型のデフォルト値をsize個作り
            .collect::<Vec<_>>()    // Vec<T>に収集してから
            .into_boxed_slice()     // Box<[T]>に変換する
    }

    // ベクタの長さを返す
    pub fn len(&self) -> usize {
        self.len
    }

    // ベクタの現在のキャパシティを返す
    pub fn capacity(&self) -> usize {
        self.elements.len()     // elementsの要素数(len)がToyVecのキャパシティになる
    }

    //pub fn push(&mut self, element: T);
    // 第1引数に&mut selfをとるため、ToyVec構造体の内容を変更することが分かる
    // 第2引数はT型のため、所有権がこのメソッドへムーブすることが分かる(そして、
    // 構造体へムーブするだろうと想像できる)

    //pub fn get(&self, index: usize) -> Option<&T>;
    // Option<&T>を返すため、selfが所有する値の不変の参照を返すことが分かる


    pub fn push(&mut self, element: T) {
        if self.len == self.capacity() {    // 要素を追加するスペースがないなら
            self.grow();        // もっと大きいelementsを確保して既存の要素を引っ越す
        }
        self.elements[self.len] = element;  // 要素を格納する(所有権がムーブする)
        self.len += 1;
    }

    pub fn get(&self, index: usize) -> Option<&T> {
        if index < self.len {   // インデックスが範囲内なら
            Some(&self.elements[index])     // Some(不変の参照)を返す
        } else {
            None                            // 範囲外ならNoneを返す
        }
    }

    // // インデックスが範囲内なら要素への参照を返し、さもなければdefaultで与えた別の値への参照を返す
    // // ライフタイムの省略規則に従い、selfと戻り値のライフタイムが同一('a)になる
    // pub fn get_or<'a, 'b>(&'a self, index: usize, default: &'b T) -> &'a T {
    //     match self.get(index) {
    //         Some(v) => v,           // selfが所有する値(elements)からの借用なので'a
    //         None => default,        // defaultのライフタイムは'b。戻り値のライフタイムと合わない
    //     }
    // }
    
    // self、default、戻り値のライフタイムを同じにする
    pub fn get_or<'a>(&'a self, index: usize, default: &'a T) -> &'a T {
        // 上のmatch式はunwrap_orコンビネータで置き換えられる
        self.get(index).unwrap_or(default)
    }
    // where節を使ってライフタイムを指定することもできる
    // pub fn get_or<'a>(&'a self, index: usize, default: &'a T) -> &'a T 
    // where
    //     'b: 'a       // 'bは'aより長く生存するという意味
    // {
    //     // valueのライフタイム'bは戻り値の'aより長い('aを含んでいる)ので問題なく返せる
    //     self.get(index).unwrap_or(default)
    // }

    fn grow(&mut self) {
        if self.capacity() == 0 {
            // 1要素文の領域を確保する
            self.elements = Self::allocate_in_heap(1);
        } else {
            // 現在の2倍の領域を確保する
            let new_elements = Self::allocate_in_heap(self.capacity() * 2);
            // self.elementsを置き換える
            let old_elements = std::mem::replace(&mut self.elements, new_elements);
            // 既存の全要素を新しい領域へムーブする
            // Vec<T>のinto_iter(self)なら要素の所有権が得られる
            for (i, elem) in old_elements.into_vec().into_iter().enumerate() {
                self.elements[i] = elem;
            }
        }
    }

    // 借用(&mut self)経由では所有権を奪えないためエラー
    pub fn pop(&mut self) -> Option<T> {        // 戻り値が参照でないことに注目。所有権ごと返す
        if self.len == 0 {
            None
        } else {
            self.len -= 1;
            // 代わりの値となら交換できる(ここではデフォルト値を使用)
            // let elem = self.elements[self.len];
            let elem = std::mem::replace(&mut self.elements[self.len], Default::default());
            Some(elem)
        }
    }

    // Option型に用意されているメソッド
    // 現在の値をムーブアウトし、元の場所にはNoneを残す
    // pub fn take(&mut self) -> Option<T>;
    // 現在の値をムーブアウトし、元の場所にはSome(value)を残す
    // pub fn replace(&mut self, value: T) -> Option<T>;

    // ライフタイムは省略可能
    pub fn iter<'vec>(&'vec self) -> Iter<'vec, T> {
        Iter {
            elements: &self.elements,       // Iter構造体の定義より、ライフタイムは'vecになる
            len: self.len,
            pos: 0,
        }
    }
    
}   // implブロックの終わり


// ライフタイムの指定により、このイテレータ自身またはnext()で得た&'vec T型の値が生存している間は、ToyVecは変更できない。
pub struct Iter<'vec, T> {
    elements: &'vec Box<[T]>,       // ToyVec構造体のelementsを指す不変の参照
    len: usize,                     // ToyVecの長さ
    pos: usize,                     // 次に返す要素のインデックス
}


impl <'vec, T> Iterator for Iter<'vec, T> {
    // 関連型(トレイトに関連付いた型)で、このイテレータがイテレートする要素の型を指定する
    type Item = &'vec T;

    // nextメソッドは次の要素を返す
    // 要素があるなら不変の参照(&T)をSomeで包んで返し、ないときはNoneを返す
    fn next(&mut self) -> Option<Self::Item> {
        if self.pos >= self.len {
            None
        } else {
            let res = Some(&self.elements[self.pos]);
            self.pos += 1;
            res
        }
    }
}