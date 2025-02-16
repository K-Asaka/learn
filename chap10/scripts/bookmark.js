let result = document.querySelector('#result');
// [検索]ボタンクリック時に実行されるコード
document.querySelector('#btn').addEventListener('click', function() {
    // クエリ情報を組み立て
    let params = new URLSearchParams();
    params.set('url', document.querySelector('#url').value)
    result.textContent = '通信中...';
    fetch(`bookmark.php?${params.toString()}`)
        .then(res => res.json())
        .then(data => {
            // ブックマークの内容を<ul>／<li>リストに整形
            let ul = document.createElement('ul');
            for (let bm of data.bookmarks) {
                let li = document.createElement('li');
                // <a>要素の生成(href属性とテキストの設定)
                let anchor = document.createElement('a');
                anchor.href = `https://b.hatena.ne.jp/${bm.user}`;
                anchor.textContent = `${bm.user} ${bm.comment}`;
                // <a>→<li>→<ul>の順にノードを組み立て
                li.append(anchor);
                ul.append(li);
            }
            // <div id="result">の配下を<ul>要素で置き換え
            result.replaceChild(ul, result.firstChild);
        })
        .catch(ex => console.log(ex));
}, false);
