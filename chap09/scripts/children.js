// <select id="food">を取得
let s = document.querySelector("#food");
// <select>要素配下の子要素を取得
let opts = s.children;
// 子要素を順に走査
for (let opt of opts) {
	console.log(opt.value);
}
