class Member {
	// インスタンスをキャッシュするための静的プロパティ
	static cache;

	static {
		this.cache = new Map();
	}

	constructor(name) {
		this.name = name;
	}

	// インスタンスを生成するための静的メソッド
	static of(name) {
		// キャッシュが存在する場合は、そのまま返す
		if (this.cache.has(name)) {
			return this.cache.get(name);
		}
		// さもなければ、新規インスタンスを生成＆キャッシュに登録
		let m = new Member(name);
		this.cache.set(name, m);
		return m;
	}
}

let m1 = Member.of('田中譲二');
let m2 = Member.of('田中譲二');
console.log(m1 === m2);
