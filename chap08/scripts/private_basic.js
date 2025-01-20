class Member {
	// プライベートプロパティ
	#name = '';
	#age = 0;

	constructor(name, age) {
		this.#name = name;
		this.#age = age;
	}

	// プライベートメソッド
	#createMessage() {
		return `私の名前は${this.#name}、${this.#age}歳です。`;
	}

	// パブリックメソッド
	show() {
		console.log(this.#createMessage());
	}
}

let m = new Member('佐藤理央', 25);
m.show();
// プライベートメンバーへのアクセスはエラー
// console.log(m.#name);
// m.#createMessage();
