// 指定されたチェックボックス(配列name)の値を設定
function setCheckValue(name, values) {
    let elems = document.querySelectorAll(`input[name="${name}"]`);

    for (let elem of elems) {
        // 配列valuesにvalue属性と等しい値が含まれるかどうかを判定
        elem.checked = values.includes(elem.value);
    }
}

// チェックボックスfoodの初期値を「餃子」「焼き肉」に
setCheckValue('food', ['餃子', '焼き肉']);
