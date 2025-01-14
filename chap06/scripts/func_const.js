let getTriangleArea = new Function(
	'base',
	'height',
	'return base * height / 2;'
);
// newを省略してもよい
// 仮引数をまとめてもよい
// 'base, height',

console.log(getTriangleArea(10, 4));
