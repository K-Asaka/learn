let data = new Map();
data.set([], '配列');
console.log(data.get([]));

// 意図したように実行するには以下のようにする
let key = [];
data.set(key, '配列');
console.log(data.get(key));
