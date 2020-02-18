new Vue({
    el: '#app',
    methods: {
        // .htmlファイルから渡されたメッセージをログ出力
        onclick: function (message) {
            console.log(message);
        }
    }
});
