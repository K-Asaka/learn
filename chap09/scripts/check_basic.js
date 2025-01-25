document.querySelector('#btn').addEventListener('click', function() {
    // 選択値を格納するための配列
    let result = [];
    let foods = document.querySelectorAll('input[name="food"]');

    // チェックボックスを走査し、チェック状態にあるかを確認
    for (let food of foods) {
        // チェックされている項目の値を配列に追加
        if (food.checked) { result.push(food.value); }
    }
    console.log(result);
}, false);
