// 高階関数arrayWalkを定義
function arrayWalk(data, callback) {
	for (let [key, value] of data.entries()) {
		// 引数callbackで指定された関数を呼び出し
		callback(value, key);
	}
}

let list = [1, 2, 4, 8, 16];
arrayWalk(
	list,
	function (value, key) {
		console.log(`${key}：${value}`);
	}
);
