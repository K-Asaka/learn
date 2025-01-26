let title = document.querySelector('#title');
let url = document.querySelector('#url');
let list = document.querySelector('#list');

// ボタンクリック時にリンクを生成
document.querySelector('#btn').addEventListener('click', function() {
    list.insertAdjacentHTML('beforeend',
        e`<li><a href="${url.value}">${title.value}</a></li>`);
}, false);
