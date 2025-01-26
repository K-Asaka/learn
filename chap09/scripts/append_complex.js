let books = [
    { title: 'ゼロからわかる TypeScript入門', price: 2948 },
    { title: 'Bootstrap 5の教科書', price: 3828 },
    { title: 'はじめてのAndroidアプリ開発', price: 3520 },
];

// 配列booksの内容を順番に<li>要素に整形
let list = document.querySelector('#list');
for (let book of books) {
    let li = document.createElement('li');
    li.textContent = `${book.title}： ${book.price}円`;
    list.append(li);
}
