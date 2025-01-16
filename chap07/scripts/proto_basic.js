// objの元となるオブジェクト
let parent = {
	x: 10,
	y: 20,
};

// parentをプロトタイプにして作成したオブジェクト
let obj = Object.create(parent, {
	z: {
		value: 30,
		writable: true,
		configurable: true,
		enumerable: true
	}
});

console.log(obj);
console.log(Object.getPrototypeOf(obj));

for (let prop in obj) {
	// 独自プロパティでなければスキップ
	if (!Object.hasOwn(prop, obj)) { continue; }
	console.log(`${prop}: ${obj[prop]}`);
}
