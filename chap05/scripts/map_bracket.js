let data = new Map();
data['壱'] = '1';
console.log(data['壱']);

// []はあくまでオブジェクト(Object)としてのブラケットのためマップとは別物
console.log(data.get('壱'));
