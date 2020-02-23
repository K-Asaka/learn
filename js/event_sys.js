new Vue({
    el: '#app',
    data: {
        name: '匿名'
    },
    methods: {
        // Alt + qでヘルプメッセージを表示
        help: function () {
            window.alert('氏名（漢字）を入力してください')
        }
    }
});
