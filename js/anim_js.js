new Vue({
    el: '#app',
    data: {
        flag: true
    },
    methods: {
        onclick: function () {
            this.flag = !this.flag;
        },
        // 要素が表示状態になる時の処理
        onenter: function (el, done) {
            Velocity(el, { opacity: 1 }, { duration: 2000, complete: done });
        },
        // 要素が表示状態になる時の処理
        onleave: function (el, done) {
            Velocity(el, { opacity: 0 }, { duration: 2000, complete: done });
        }
    }
});
