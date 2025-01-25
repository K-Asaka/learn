let name = document.querySelector('#name');
let resul = document.querySelector('#result');

// ボタンクリック時にあいさつメッセージを反映
document.querySelector('#btn').addEventListener('click', function() {
    result.innerHTML = `こんにちは、${name.value}さん！`;
}, false);
