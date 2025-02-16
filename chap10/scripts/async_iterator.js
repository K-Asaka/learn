// 非同期ジェネレーターを定義
async function* getContents(...list) {
    for (let name of list) {
        let result = await fetch(name);
        yield result.json();
    }
}

// 指定のファイルから順に書名(title)を取得＆列挙
async function main() {
    for await (let data of getContents('book1.json', 'book2.json', 'book3.json')) {
        console.log(data.title);
    }
}

main();
