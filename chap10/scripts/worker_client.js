let target = document.querySelector('#target');
let x = document.querySelector('#x');
let result = document.querySelector('#result');

document.querySelector('#btn').addEventListener('click', function() {
    let worker = new Worker('scripts/worker.js');
    // ワーカーにメッセージを送信
    worker.postMessage({
        target: target.value,
        x: x.value
    });
    result.textContent = '計算中...';

    // ワーカーからの応答を処理
    worker.addEventListener('message', function(e) {
        result.textContent = e.data;
    }, false);

    // ワーカーでエラーが発生した場合の処理
    worker.addEventListener('error', function(e) {
        result.textContent = e.message;
    }, false);
}, false);

// 実行中のワーカーを中断するには、terminateメソッドを使う
// ワーカー自身で処理を終了するなら、closeメソッドを使う
// worker.terminate();
// self.close();
