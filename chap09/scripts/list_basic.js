// 指定されたリストボックス(name)の値を取得
function getSelectValue(name) {
    // 選択値を格納するための配列
    let result = [];
    let opts = document.querySelector(name).options;

    // <option>要素を走査し、チェック状態にあるかを確認
    for (let opt of opts) {
        if (opt.selected) { result.push(opt.value); }
    }
    return result;
}

// ボタンクリック時に選択項目の値をダイアログ表示
document.querySelector('#btn').addEventListener('click', function() {
    console.log(getSelectValue('#food'));
}, false);
