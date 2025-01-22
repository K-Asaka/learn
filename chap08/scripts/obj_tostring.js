class Coordinate {
	constructor(x, y) {
		this.x = x;
		this.y = y;
	}

	// 座標の文字列表現を返す
	toString() {
		return `(${this.x}, ${this.y})`;
	}

	// 座標の数値表現を返す
	valueOf() {
		return Math.sqrt(this.x ** 2 + this.y ** 2);
	}

	// 基本型変換のルールを定義
	[Symbol.toPrimitive](hint) {
		if (hint === 'number') {
			return this.valueOf();
		}
		return this.toString();
	}
}

let c = new Coordinate(5, 2);
console.log(`${c}`);
console.log(+c);
console.log(c + '');
