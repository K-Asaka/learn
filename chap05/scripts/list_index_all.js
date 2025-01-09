let list = ['い', 'ろ', 'は', 'に', 'い', 'へ', 'と'];
let keywd = 'い';
let result = [];

list.forEach(function(v, i) {
	// 合致する要素があれば、そのインデックス値を結果に追加
	if (v === keywd) { result.push(i); }
});
console.log(result);
