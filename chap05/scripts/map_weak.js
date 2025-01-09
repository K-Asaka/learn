let obj = {};
let data = new WeakMap();
data.set(obj, 'ほげ');
obj = null;		// オブジェクトを破棄
console.log(data.size);
