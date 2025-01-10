let code = 'const HOGE = "ほげ"';
let re = /[A-Z0-9_]+/y;

// 6文字目でマッチ
re.lastIndex = 6;
console.log(code.match(re));
