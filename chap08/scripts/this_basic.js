globalThis.name = '大山田';

let member = {
	name: '小山田',
	greet() {
		console.log(`こんにちは、${this.name}さん！`);
	}
}

function myHigher(fn) {
	fn();
}

myHigher(member.greet);
myHigher(member.greet.bind(member));
