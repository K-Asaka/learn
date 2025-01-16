function getTriangleArea(base=10, height=base) {
	return base * height / 2;
}

function formatTime(date = Date.now()) {
	console.log(date);
}

console.log(getTriangleArea());
console.log(getTriangleArea(4));
console.log(getTriangleArea(1, 2));
formatTime();
