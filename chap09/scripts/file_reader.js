let file = document.querySelector('#file');
let reader = new FileReader();
// 読み取り成功時に、その内容をページに反映
reader.addEventListener('load', function() {
    document.querySelector('#result').textContent = reader.result;
}, false);

reader.addEventListener('error', function() {
    console.log(reader.error.message);
}, false);

// ボタンクリックでファイルの読み取りを開始
document.querySelector('#btn').addEventListener('click', function() {
    reader.readAsText(file.files[0], 'UTF-8');
}, true);
