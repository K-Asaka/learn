let list = [ 10, 42, null, 73, 8 ];

console.log(
	list.flatMap(function(value) {
		// null値の場合は空配列を返す
		if (value === null) { return []; }
		return value;
	})
);
