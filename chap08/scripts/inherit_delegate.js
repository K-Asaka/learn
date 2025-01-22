class Queue {
	#list = [];

	// 引数の内容で配列を初期化
	constructor(...data) {
		this.#list = data;
	}

	// #list経由で値を操作
	enqueue(elem) {
		this.#list.push(elem);
	}

	dequeue() {
		return this.#list.shift();
	}

	peek() {
		return this.#list[0];
	}
}

let q = new Queue(10, 20, 30);
q.enqueue(40);
console.log(q.dequeue());
console.log(q.peek());
