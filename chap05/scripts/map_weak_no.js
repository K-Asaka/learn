let obj = {};
let data = new Map();
data.set(obj, 'ほげ');
obj = null;		// オブジェクトを破棄
console.log(data.size);
