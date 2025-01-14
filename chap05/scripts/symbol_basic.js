let sym1 = Symbol('sym');
let sym2 = Symbol('sym');

console.log(typeof sym1);
console.log(sym1.toString());
console.log(sym1.description);
console.log(sym1 === sym2);

// エラー
// console.log(sym1 + '');
// console.log(sym1 - 0);

console.log(typeof !!sym1);

// 主な使用例(定数)
// const MONDAY = 0;
// const TUESDAY = 1;
// if (week === MONDAY) { console.log('MONDAY'); }
const MONDAY = Symbol();
const TUESDAY = Symbol();

week = MONDAY;
if (week === MONDAY) { console.log('Monday'); }
