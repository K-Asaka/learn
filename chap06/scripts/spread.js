console.log(Math.max(15, -3, 78, 1));
console.log(Math.max([15, -3, 78, 1]));
console.log(Math.max(...[15, -3, 78, 1]));
// ES2015以前
console.log(Math.max.apply(null, [15, -3, 78, 1]));
