let data = new Set(['壱', '弐', '参']);

data.forEach(function(value, key, set) {
	console.log(value);
});

// 以下のようにも表せる
for (let value of data) {
	console.log(value);
}
