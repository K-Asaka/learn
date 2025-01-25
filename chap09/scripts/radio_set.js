// 指定されたラジオボタン(name)を指定値valueで設定
function setRadioValue(name, value) {
    let elems = document.querySelectorAll(`input[name="${name}"]`);

    // ラジオボタンを走査し、値の等しいものを検出
    for (let elem of elems) {
        // 引数valueと等しい値を持つ項目を選択状態に
        if (elem.value === value) {
            elem.checked = true;
            break;
        }
    }
}

// ラジオボタンfoodの初期値を「餃子」に
setRadioValue('food', '餃子');