let list = document.querySelectorAll('#list a');
let pic = document.querySelector('#pic');
let del = document.querySelector('#del');

// 個々のリンクに順にリスナーを登録
for (let li of list) {
    li.addEventListener('click', function(e) {
        // data-isbn属性からアンカータグに紐づいたisbn値を取得
        let isbn = this.getAttribute('data-isbn');

        // isbn値が取得できた場合にのみ処理を実行
        if (isbn) {
            // <img>要素を生成
            let img = document.createElement('img');
            img.src = `https://wings.msn.to/books/${isbn}/${isbn}.jpg`;
            img.alt = e.textContent;
            img.height = 150;
            img.width = 108;
            if (pic.querySelector('img')) {
                // <img>要素が存在する場合、新たな<img>要素で置換
                pic.replaceChild(img, pic.lastChild);
            } else {
                // <img>要素が存在しない場合、新たに追加し、[削除]ボタンを有効に
                del.disabled = false;
                pic.append(img);
            }
        }
    }, false);
}

// [削除]ボタンがクリックされた時の処理
del.addEventListener('click', function() {
    // <div id="pic">配下の子要素を削除し、[削除]ボタンを無効に
    pic.removeChild(pic.lastChild);
    del.disabled = true;
}, false);
