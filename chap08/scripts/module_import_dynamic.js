import('./lib/util.js').then(util => {
	console.log(util.getTriangleArea(10, 2));

	let m = new util.Member('佐藤理央', 25);
	m.show();
})

let util = await import('./lib/util.js');
console.log('util=', util);
