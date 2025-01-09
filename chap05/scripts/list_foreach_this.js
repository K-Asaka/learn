let list = [ 10, 42, null, 73, 8 ];

// 処理結果を格納するための配列
let result = [];

list.forEach(function(value) {
	// nullでない場合にだけ結果配列に反映
	if (value !== null) {
		// thisはresultを示す
		this.push(value);
	}
}, result);
console.log(result);
