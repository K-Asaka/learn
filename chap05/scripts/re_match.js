let re = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/gi;
let str = `サポートサイトはhttp://www.example.com/です。
		   サンプル紹介サイトHTTPS://www.web-deli.com/もよろしく！`;
let results = str.match(re);
for (let result of results) {
	console.log(result);
}

// グローバル検索を無効にする - gオプション
re = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/i;
results = str.match(re);
for (let result of results) {
	console.log(result);
}

// 大文字/小文字を区別する - iオプション
re = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/g;
results = str.match(re);
for (let result of results) {
	console.log(result);
}
