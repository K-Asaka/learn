let btn = document.querySelector('#btn');
let listener = function() {
    console.log('こんにちは、世界！');
}

// イベントリスナーを登録
btn.addEventListener('click', listener, false);
// イベントリスナーを削除
btn.removeEventListener('click', listener, false);
