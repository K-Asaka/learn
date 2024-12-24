let data = ['apple', 'orange', 'banana'];
// 配列オブジェクトにhogeメソッドを追加
Array.prototype.hoge = function() {}

for (let key in data) {
	console.log(data[key]);
}
