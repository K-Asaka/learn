class Member {
	constructor(name = '名無権兵衛') {
		this.name = name;
	}
	greet() {
		return `こんにちは、${this.name}さん！`;
	}
}

// Memberクラスを継承したBusinessMemberクラスを定義
class BusinessMember extends Member {
	// greetメソッドをオーバーライド
	greet(title) {
		return `こんにちは、${this.name}${title}！`;
	}
}

let bm = new BusinessMember('佐藤理央');
console.log(bm.greet('課長'));
console.log(bm.greet());
