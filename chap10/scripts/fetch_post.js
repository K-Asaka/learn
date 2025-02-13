let result = document.querySelector('#result');
// [送信]ボタンクリック時に入力値を送信
document.querySelector('#btn').addEventListener('click', function() {
    // フォームデータの組み立て
    let data = new FormData(document.querySelector('#myform'));
    fetch('fetch_post.php', {
        method: 'POST',
        body: data,
    })
    .then(res => res.text())
    .then(text => result.textContent = text);
}, false);
