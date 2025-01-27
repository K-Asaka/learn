let parent = document.querySelector('#parent');
// 目的の親要素に対してリスナーを登録
parent.addEventListener('click', function(e) {
    // 本来、イベントを紐づけたい要素を判定
    if (e.target.dataset.add) {
        let btn = document.createElement('input');
        btn.type = 'button';
        btn.value = 'Add';
        btn.dataset.add = 1;
        parent.append(btn);
    }
}, false);
