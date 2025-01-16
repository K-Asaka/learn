'use strict';

let member = Object.create(Object.prototype, {
	name: {
		value: '佐藤理央',
		writable: true,
		configurable: true,
		enumerable: true
	},
	birth: {
		value: new Date(2010, 5, 25),
		writable: true,
		configurable: true,
		enumerable: true
	},
	memo: {
		value: '仮入部期間中です。',
		writable: true,
		configurable: true,
		enumerable: true
	}
});

// プロパティ値への書き込み
member.memo = '正式入部しました。';

// プロパティ値の列挙
for (let prop in member) {
	console.log(`${prop}: ${member[prop]}`);
}

// プロパティの破棄
delete member.memo;
