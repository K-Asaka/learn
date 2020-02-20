new Vue({
    el: '#app',
    data: {
        list: [ '赤パジャマ', '青パジャマ', '黃パジャマ' ]
    },
    methods: {
        // ボタンクリック時に2番目の要素を変更
        onclick: function () {
            Vue.set(this.list, 1, '茶パジャマ');
        }
    }
});