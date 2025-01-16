function getTriangleArea(base=10, height=5) {
	return base * height / 2;
}

function formatTime(date = Date.now()) {
	console.log(date);
}

console.log(getTriangleArea());
console.log(getTriangleArea(4));
console.log(getTriangleArea(1, 2));
formatTime();

// 既定値が適用されるのは、値が渡されなかった場合
console.log(getTriangleArea(5, null));	// 明示的に渡された場合、既定値は適用されない
console.log(getTriangleArea(5, undefined));
