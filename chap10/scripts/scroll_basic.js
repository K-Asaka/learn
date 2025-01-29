// document.querySelector('#main').addEventListener('click', function() {
//     // 表示サイズ分だけスクロール
//     window.scrollBy(0, window.innerHeight);
// }, false);

document.querySelector('#main').addEventListener('click', function(e) {
    // ターゲット要素の祖先でid="chap_XX">であるものを取得
    let p = e.target.closest('[id^="chap"]');
    if (p) {
        // 移動先の章番号を生成＆移動
        let next = `#chap_${Number(p.id.split('_')[1]) + 1}`;
        document.querySelector(next)?.scrollIntoView(true);
    }
}, false);
