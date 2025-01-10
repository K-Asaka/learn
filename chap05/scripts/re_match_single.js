let re = /^.+/g;
let str = 'こんにちは。\n私の名前は鈴木三郎です。';

let results = str.match(re);
for (let result of results) {
	console.log(result);
}

// シングルラインモードを有効にする
// 「.」は\nなどの行末文字も含むようになる
re = /^.+/gs;
results = str.match(re);
for (let result of results) {
	console.log(result);
}
