let book = {
	title: 'JavaScript本格入門',
	price: 2980,
	publisher: '技術評論社',
};

console.log(book.title);
console.log(book['title']);

book.author = 'Y.Yamada';	// 新たなプロパティを追加
book.title = '改訂3版 JavaScript本格入門';	// 既存の要素を書き換え

console.log(book.author);
console.log(book.title);
