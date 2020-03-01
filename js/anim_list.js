new Vue({
    el: '#app',
    data: {
        todo: '',
        // Todoリスト (初期値)
        items: [
            'A書籍の構成案作成',
            'X記事の著者校正',
            '今月締の請求書作成',
            'WINGSメンバーの面接'
        ]
    },
    methods: {
        // 新たに入力された項目は配列の先頭に追加
        onadd: function () {
            this.items.unshift(this.todo);
            this.todo = '';
        },
        // 指定された項目を配列から除外
        onremove: function () {
            let that = this;
            this.items = this.items.filter(function (value) {
                return value !== that.todo;
            });
            this.todo = '';
        },
    }
});
