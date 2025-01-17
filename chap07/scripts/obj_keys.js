let obj = Object.create(Object.prototype, {
	name: {
		value: '佐藤理央',
		writable: true,
		configurable: true,
		enumerable: true
	},
	age: {
		value: 25,
		writable: false,
		configurable: true,
		enumerable: false
	},
	gender: {
		value: 'male',
		writable: true,
		configurable: true,
		enumerable: true
	}
});

for (let prop of Object.keys(obj)) {
	console.log(Object.getOwnPropertyDescriptor(obj, prop));
}

// 列挙の可否を問わず現在のオブジェクトのすべてのプロパティを取得する
for (let prop of Object.getOwnPropertyNames(obj)) {
	console.log(Object.getOwnPropertyDescriptor(obj, prop));
}

// プロパティが列挙可能か判定する
console.log(obj.propertyIsEnumerable('age'));

// プロパティ記述子をまとめて取得する
console.log(Object.getOwnPropertyDescriptors(obj));
