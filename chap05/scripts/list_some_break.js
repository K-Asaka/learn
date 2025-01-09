let list = [ 10, 42, null, 73, 8 ];

list.some(function(value) {
	// 値がnullの場合は戻り値をtrue
	if (value === null) { return true; }
	console.log(value);
});
