function sum(init, ...nums) {
	let result = init;
	for (let num of nums) {
		if (typeof num !== 'number') {
			throw new Error(`指定値が数値ではありません：${num}`);
		}
		result += num;
	}
	return result;
}

console.log(sum(1, 3, 5, 7, 9));
console.log(sum());
