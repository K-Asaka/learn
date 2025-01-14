function getTriangleArea(base, height) {
	if (base <= 0 || height <= 0) { return 0; }
	return base * height / 2;
}

let area = getTriangleArea(10, 4);
console.log(area);
