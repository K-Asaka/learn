let value = [1, 2, 4, 8, 16];

function updateArray(value) {
	// 配列そのものを置き換え
	value = [10, 20, 30];
	return value;
}

console.log(updateArray(value));
console.log(value);
