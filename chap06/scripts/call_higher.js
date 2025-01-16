// 高階関数arrayWalkを定義
function arrayWalk(data, callback) {
	for (let [key, value] of data.entries()) {
		// 引数callbackで指定された関数を呼び出し
		callback(value, key);
	}
}

// 配列を処理するためのユーザー定義関数
function showElement(value, key) {
	console.log(`${key}：${value}`);
}

let list = [1, 2, 4, 8, 16];
arrayWalk(list, showElement);
