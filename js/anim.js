new Vue({
    el: '#app',
    data: {
        flag: true
    },
    methods: {
        // ボタンクリック時に表示状態をオンオフ
        onclick: function () {
            this.flag = !this.flag;
        }
    }
});
