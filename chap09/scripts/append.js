let title = document.querySelector('#title');
let url = document.querySelector('#url');
let list = document.querySelector('#list');

// ボタンクリック時にリンクを生成
document.querySelector('#btn').addEventListener('click', function() {
    // <li>要素を生成
    let li = document.createElement('li');
    // <a>要素を生成
    let anchor = document.createElement('a');
    // <a>要素のhref属性、本体を設定
    anchor.href = url.value;
    anchor.textContent = title.value;
    // <ul>要素の配下に<li>→<a>要素の階層で追加
    li.append(anchor);
    list.append(li);
}, false);
