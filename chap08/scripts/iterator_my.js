class MyIterator {
	// 引数経由で渡された配列をdataプロパティに設定
	constructor(data) {
		this.data = data;
	}
	
	// 既存のイテレーターを取得するためのメソッドを定義
	[Symbol.iterator]() {
		let current = 0;
		let that = this;
		return {
			// dataプロパティの次の要素を取得
			next() {
				return current < that.data.length ?
					{ value: that.data[current++], done: false } :
					{ done: true };
			}
		};
	}
}

// MyIteratorクラスで保持された配列を列挙
let itr = new MyIterator(['one', 'two', 'three']);
for (let value of itr) {
	console.log(value);
}
