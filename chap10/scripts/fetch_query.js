let result = document.querySelector('#result');
// [送信]ボタンクリック時に入力値を送信
document.querySelector('#btn').addEventListener('click', function() {
    // クエリ情報の組み立て
    let params = new URLSearchParams();
    params.set('name', document.querySelector('#name').value);
    // クエリ情報を付与してリクエストを発信
    // fetch(`https://example.com/fetch_query.php?${params.toString()}`)
    fetch(`fetch_query.php?${params.toString()}`)
        .then(res => res.text())
        .then(text => result.textContent = text);
}, false);
