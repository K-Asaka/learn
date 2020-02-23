new Vue({
    el: '#app',
    data: {
        name: '匿名'
    },
    methods: {
        // Escキーでテキストをクリア
        clear: function () {
            this.name = '';
        }
    }
});
