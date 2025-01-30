let count = 0;
let result = document.querySelector('#result');

// [カウントアップ]ボタンをクリックした時に履歴を追加
document.querySelector('#btn').addEventListener('click', function() {
    result.textContent = ++count;
    history.pushState(count, '', `/js/chap07/count/${count}`);
});

// [戻る]ボタンでページの状態を前に戻す
window.addEventListener('popstate', function(e) {
    count = e.state;
    result.textContent = count;
});
