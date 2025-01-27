// <a id="inner">要素のclickイベントリスナー
document.querySelector('#inner').addEventListener('click', function(e) {
    window.alert('#innerリスナーが発生しました。');
    e.stopPropagation();
}, false);

document.querySelector('#inner').addEventListener('click', function() {
    window.alert('#innerリスナー 2が発生しました。');
}, false);

// <div id="outer">要素のclickイベントリスナー
document.querySelector('#outer').addEventListener('click', function() {
    window.alert('#outerリスナーが発生しました。');
}, false);
