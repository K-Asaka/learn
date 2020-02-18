new Vue({
    el: '#app',
    data: {
        path: 'http://www.web-deli.com/image/linkbanner_l.gif'
    },
    methods: {
        // 画像にマウスポインターが乗ったとき
        onmouseenter: function() {
            this.path = 'http://www.web-deli.com/image/home_chara.gif';
        },
        // 画像からマウスポインターが外れたとき
        onmouseleave: function() {
            this.path = 'http://www.web-deli.com/image/linkbanner_l.gif';
        }
    }
});
