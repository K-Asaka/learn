new Vue({
    el: '#app',
    data: {
        list: [ '赤パジャマ', '青パジャマ', '黃パジャマ' ]
    },
    methods: {
        // ボタンクリック時に2番目の要素を変更
        onclick: function () {
            // 配列の先頭要素を削除
            this.list.shift();
        }
    }
});