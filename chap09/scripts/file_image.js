let file = document.querySelector('#file');
let reader = new FileReader();
// 読み取り成功時に、その内容をページに反映
reader.addEventListener('load', function() {
    document.querySelector('#result').src = reader.result;
}, false);

// ボタンクリックでファイルの読み取りを開始
file.addEventListener('change', function() {
    reader.readAsDataURL(file.files[0]);
}, false);
