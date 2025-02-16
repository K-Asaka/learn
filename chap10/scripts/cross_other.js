let origin = 'http://127.0.0.1:5500';
let result = document.querySelector('#result');

window.addEventListener('message', function(e) {
    if (e.origin !== origin) { return; }
    result.textContent = e.data;
    // 現在の日時を返送
    e.source.postMessage(new Date(), origin);
}, false);
