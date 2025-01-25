let imgs = document.querySelectorAll('img');
let deps = ['align', 'border', 'hspace', 'vspace', 'longdesc', 'name'];
// すべての<img>要素を走査
for (let img of imgs) {
    // 非推奨属性を順に削除
    for (let dep of deps) {
        img.removeAttribute(dep);
    }
}
