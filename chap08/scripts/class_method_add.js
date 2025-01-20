class Member {
	constructor(name='名無権兵衛', age=0) {
		this.name = name;
		this.age = age;
	}

	show() {
		console.log(`私の名前は${this.name}、${this.age}歳です。`);
	}
}

let m = new Member('佐藤理央', 25);
// greetメソッドを追加
Member.prototype.greet = function() {
	console.log(`こんにちは、${this.name}さん！`);
};

m.greet();
