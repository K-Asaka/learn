let result = document.querySelector('#result');
// タイマーを設置
let timer = window.setInterval(
    function() {
        // 現在の時刻を<div>要素に表示(5000ミリ秒ごとに更新)
        result.textContent = (new Date()).toLocaleTimeString();
    }, 5000);

// ボタンクリック時にタイマー処理を中止
document.querySelector('#btn').addEventListener('click', function() {
        window.clearInterval(timer);
    }, false);
