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
	work() {
		return `${this.name}は働いています！`;
	}
}

let bm = new BusinessMember('佐藤理央');
console.log(bm.greet());
console.log(bm.work());
