let parent = {
	x: 10,
	y: 20,
};

let obj = Object.create(parent, {
	z: {
		value: 30,
		writable: true,
		configurable: true,
		enumerable: true
	}
});

obj.x = 108;
console.log(obj.x);
console.log(parent.x);

console.log(delete obj.x);
console.log(obj.x);
console.log(parent.x);

console.log(delete obj.x);
console.log(obj.x);
console.log(parent.x);

// プロトタイプ経由のプロパティを強制的に削除する方法
delete Object.getPrototypeOf(obj).x;
console.log(parent.x);

// プロトタイプで提供されるプロパティを現在のオブジェクト上で削除する
obj.x = undefined
console.log(obj.x);
// プロパティの存在はそのままに、値を強制的に未定義にしている

// プロトタイプそのものを入れ替える
let new_parent = {
	a: 'Hello'
};
Object.setPrototypeOf(obj, new_parent);
console.log(obj.a);
Object.setPrototypeOf(obj, null);
console.log(obj.a);
