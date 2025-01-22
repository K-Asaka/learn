class Queue extends Array {
	// キューに要素を追加
	enqueue(elem) {
		super.push();
	}

	// キューから要素を取り出す
	dequeue() {
		return super.shift();
	}

	// キューから要素を取り出す(削除しない)
	peek() {
		return this[0];
	}

	// その他の不要なメソッドを無効化
	reverse() {
		throw new Error('reverse is not supported.');
	}
}

let q = new Queue(10, 20, 30);
q.enqueue(40);
console.log(q.dequeue());
console.log(q.peek());

let list = new Queue(10, 20, 30);
list.reverse();		// 無効化されており、リスコフの置換原則に反する
