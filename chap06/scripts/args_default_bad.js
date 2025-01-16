function getTriangleArea(base=1, height) {
	return base * height / 2;
}

// baseに10が渡され、heightはundefinedになる
console.log(getTriangleArea(10));
