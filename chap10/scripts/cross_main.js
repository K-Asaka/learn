let target = 'http://localhost:8000';
let frame = document.querySelector('#frame');
let message = document.querySelector('#message');

// [送信]ボタンクリック時にフレーム側にメッセージを送信
document.querySelector('#btn').addEventListener('click', function() {
    frame.contentWindow.postMessage(message.value, target);
}, false);
