class Member {
	#name = '';
	#birth = new Date();

	constructor(name, birth) {
		this.#name = name;
		this.#birth = new Date(birth.getTime());
		Object.freeze(this);
	}

	get name() {
		return this.#name;
	}

	// 参照型を返すゲッター
	get birth() {
		return new Date(this.#birth.getTime());
	}

	show() {
		console.log(`私の名前は${this.#name}、誕生日は${this.#birth.toDateString()}です。`);
	}

	// nameだけを変更した複製を生成
	withName(name) {
		return new Member(name, this.birth);
	}
}
Object.freeze(Member.prototype);

let m = new Member('佐藤理央', new Date('1990/2/21'));
m.show();
console.log(m.name);
console.log(m.birth);

m.withName('山田太郎').show();
m.show();

// エラー
//m.prototype.func = () => console.log('func()');
