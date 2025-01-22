class MyIterator {
	// 引数経由で渡された配列をdataプロパティに設定
	constructor(data) {
		this.data = data;
	}
	
	*[Symbol.iterator]() {
		let current = 0;
		while (current < this.data.length) {
			yield this.data[current++];
		}
	}
}

// MyIteratorクラスで保持された配列を列挙
let itr = new MyIterator(['one', 'two', 'three']);
for (let value of itr) {
	console.log(value);
}
