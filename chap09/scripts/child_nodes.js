let s = document.querySelector("#food");
let opts = s.childNodes;
// 子ノードを順に走査
for (let opt of opts) {
	// 子ノードが要素ノードである場合にのみ、その値をログ表示
	if (opt.nodeType === 1) { console.log(opt.value); }
}
