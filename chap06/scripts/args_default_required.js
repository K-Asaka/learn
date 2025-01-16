function show(x, y = 1) {
	console.log(`x = ${x}`);
	console.log(`y = ${y}`);
}
show();

function show_ex(x, y = 1) {
	if (x === undefined) { throw new Error('x is required.'); }
	console.log(`x = ${x}`);
	console.log(`y = ${y}`);
}
show_ex(5);
show_ex();	// エラー
