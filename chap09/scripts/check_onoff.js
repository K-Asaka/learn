let onoff = document.querySelector('#onoff');

document.querySelector('#btn').addEventListener('click', function() {
    // チェックボックスon／offの状態に応じて、ログを出力
    if (onoff.checked) {
        console.log(onoff.value);
    } else {
        console.log('チェックされていません。');
    }
 }, false);
 