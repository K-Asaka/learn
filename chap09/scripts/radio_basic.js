function getRadioValue(name) {
    let result = '';
    let elems = document.querySelectorAll(`input[name="${name}"]`);

    // ラジオボタンを走査し、チェック状態にあるかを確認
    for (let elem of elems) {
        // チェックされている項目の値を配列に追加
        if (elem.checked) {
            result = elem.value;
            break;
        }
    }
    return result;
}

// ボタンクリック時に選択項目の値をダイアログ表示
document.querySelector('#btn').addEventListener('click', function() {
    console.log(getRadioValue('food'));
}, false);
