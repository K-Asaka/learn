Vue.directive('highlight', {
    bind: function (el, binding) {
        // mouseenter時のイベント処理を定義
        el.addEventListener('mouseenter', function () {
            this.style.backgroundColor = binding.value;
        }, false);
        // mouseleave時のイベント処理を定義
        el.addEventListener('mouseleave', function() {
            this.style.backgroundColor = null;
        }, false);
    }
});

new Vue({
    el: '#app',
    data: {
        color: 'yellow'
    }
});
