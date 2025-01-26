let books = [
    { title: 'ゼロからわかる TypeScript入門', price: 2948 },
    { title: 'Bootstrap 5の教科書', price: 3828 },
    { title: 'はじめてのAndroidアプリ開発', price: 3520 },
];

// コンテンツを貯めるためのDocumentFragmentオブジェクトを生成
let frag = document.createDocumentFragment();
// 配列booksの内容を順番に<li>要素に整形
for (let book of books) {
    let li = document.createElement('li');
    li.textContent = `${book.title}： ${book.price}円`;
    frag.append(li);
}
// <li>要素群をまとめて文書ツリーに追加
document.querySelector('#list').append(frag);
