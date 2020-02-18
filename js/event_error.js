new Vue({
    el: '#app',
    data: {
        path: './images/wings.jpg'
    },
    methods: {
        // 画像を読み込めない場合はエラー画像を表示
        onerror: function() {
            this.path = './images/noimage.jpg';
        }
    }
});
