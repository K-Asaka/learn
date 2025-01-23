let s = document.querySelector("#food");
// <select>要素の最初の子要素を取得
let child = s.firstElementChild;
// 弟要素が存在する間、ループを継続(ない場合はnullでループを終了)
while (child) {
	console.log(child.value);
	child = child.nextElementSibling;
}
