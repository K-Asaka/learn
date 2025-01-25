let elem = document.querySelector('#elem');

// マウスポインターが乗ったタイミングで背景色を変更
elem.addEventListener('mouseenter', function() {
    this.style.backgroundColor = 'Yellow';
}, false);

// マウスポインターが外れたタイミングで背景色を戻す
elem.addEventListener('mouseleave', function() {
    this.style.backgroundColor = '';
}, false);
