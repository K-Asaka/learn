let list = [1, 2, 3, 4, 5];
let copy = Array.from(list);

console.log(copy);
console.log(list === copy);

// 代入演算子では同じ配列を参照する
copy = list;
console.log(list === copy);
