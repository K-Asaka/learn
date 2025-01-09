let data = new Map();
data.set('1st', 'ファースト');
data.set('2nd', 'セカンド');
console.log(data.delete('1st'));
console.log(data.delete('3rd'));

// マップに存在するすべてのキーを破棄
data.clear();
console.log(data);
