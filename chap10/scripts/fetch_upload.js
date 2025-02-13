let result = document.querySelector('#result');
let upfile = document.querySelector('#upfile');
// ファイル指定時にファイルをアップロード
upfile.addEventListener('change', function() {
    // アップロード用にフォームデータを生成
    let f = upfile.files[0];
    let data = new FormData();
    data.append('upfile', f, f.name);
    // ファイルをポストデータとして送信
    fetch('fetch_upload.php', {
        method: 'POST',
        body: data,
    })
    .then(res => res.text())
    // アップロード結果を表示
    .then(text => result.textContent = text);
}, false);
