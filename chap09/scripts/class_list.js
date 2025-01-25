let elem = document.querySelector('#elem');

elem.addEventListener('mouseenter', function() {
    // スタイルクラスhighlightを付与
    this.classList.add('highlight');
}, false);

elem.addEventListener('mouseleave', function() {
    // スタイルクラスhighlightを破棄
    this.classList.remove('highlight');
}, false);
