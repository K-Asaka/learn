// 高階関数arrayWalkを定義
function arrayWalk(data, callback) {
	for (let [key, value] of data.entries()) {
		// 引数callbackで指定された関数を呼び出し
		callback(value, key);
	}
}

// 結果値を格納するためのグローバル変数
let result = 0;
function showElement(value, key) {
	// 与えられた配列要素で変数resultを加算
	result += value;
}

let list = [1, 2, 4, 8, 16];
arrayWalk(list, showElement);
console.log(`合計値：${result}`);
