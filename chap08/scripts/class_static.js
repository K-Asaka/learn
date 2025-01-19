class Area {
	// 静的プロパティ
	static pi = 3.14

	// 静的メソッド
	static circle(radius) {
		return (radius ** 2) * this.pi;
	}
}

console.log(Area.pi);
console.log(Area.circle(10));
