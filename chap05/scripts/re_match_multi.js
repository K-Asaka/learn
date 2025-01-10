let re = /^[0-9]{1,}/g;
let str = '101匹ワンちゃん。\n7人の小人';

let results = str.match(re);
for (let result of results) {
	console.log(result);
}


console.log('マルチラインモードを有効化');
re = /^[0-9]{1,}/gm;
results = str.match(re);
for (let result of results) {
	console.log(result);
}
