class MyStorage {
    // アプリ名
    #app;
    // 利用するストレージの種類(ここではローカルストレージ)
    #storage = localStorage;
    // ストレージから読み込んだオブジェクト
    #data;

    constructor(app) {
        this.#app = app;
        // 現在のストレージの内容で初期化(データが無い場合は空オブジェクトを生成)
        this.#data = JSON.parse(this.#storage[this.#app] || '{}');
    }

    // 指定されたキーで値を取得
    getItem(key) {
        return this.#data[key];
    }

    // 指定されたキー／値でオブジェクトを書き換え
    setItem(key, value) {
        this.#data[key] = value;
    }

    // MyStorageオブジェクトの内容をストレージに保存
    save() {
        this.#storage[this.#app] = JSON.stringify(this.#data);
    }
}

export { MyStorage };
