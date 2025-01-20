class Member {
	// name／ageプロパティの格納先(プライベートメンバー)
	#name = '';
	#age = 0;

	constructor(name, age) {
		this.#name = name;
		this.#age = age;
	}

	// nameゲッター
	get name() {
		return this.#name;
	}

	// ageゲッター
	get age() {
		return this.#age;
	}

	// ageセッター
	set age(value) {
		// 不正な値は例外をスロー
		if (typeof(value) !== 'number' || value < 0) {
			throw new TypeError('ageは0以上の数値で指定してください。');
		}
		this.#age = value;
	}

	show() {
		console.log(`私の名前は${this.#name}、${this.#age}歳です。`);
	}
}

let m = new Member('佐藤理央', 25);
m.show();
m.age = -18;

