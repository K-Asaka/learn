let list = Array.from(
	{ length: 5 },
	function(value, index) {
		return index * 10;
	}
);

console.log(list);

let data = new Array(5);
data.fill('ー', 0, data.length);
console.log(data);
