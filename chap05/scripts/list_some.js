let books = [
	{ title: 'TypeScript入門', price: 2948 },
	{ title: 'Bootstrapの教科書', price: 3828 },
	{ title: 'はじめてのAndroidアプリ開発', price: 3520 },
	{ title: '基礎から学ぶC#の教科書', price: 3190 },
	{ title: 'これからはじめるVue.js実践入門', price: 3740 },
];

// some: 1つでも戻り値がtrueを返したら
console.log(books.some(function(value) {
	return value.price < 3000;
}));

// every: すべての戻り値がtrueであったら
console.log(books.every(function(value) {
	return value.price < 3000;
}));
