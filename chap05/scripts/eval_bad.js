let obj = { hoge: 1, foo: 2 };
let prop = 'hoge';
eval(`console.log(obj.${prop})`);

// ブラケット構文を利用したほうがシンプルで安全
console.log(obj[prop]);
