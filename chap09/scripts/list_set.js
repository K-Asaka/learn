// 指定されたリストボックス(配列name)の値を設定
function setListValue(name, values) {
    let opts = document.querySelector(name).options;

    // <option>要素を順に走査
    for (let opt of opts) {
        // 配列valuesにvalue属性と等しい値が含まれる場合は選択状態に
        opt.selected = values.includes(opt.value);
    }
}

// リストボックスfoodの初期値を「餃子」「焼き肉」に
setListValue('#food', ['餃子', '焼き肉']);
