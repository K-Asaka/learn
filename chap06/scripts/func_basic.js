function getTriangleArea(base, height) {
	if (base <= 0 || height <= 0) { return 0; }
	return base * height / 2;
}

// 戻り値がない関数
function showTriangleArea(base, height) {
	console.log(base * height / 2);
}

let area = getTriangleArea(10, 4);
console.log(area);

showTriangleArea(10, 4);
