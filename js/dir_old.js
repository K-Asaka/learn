Vue.directive('highlight', function (el, binding, vnode, oldVnode) {
    // 現在の属性値をログ出力
    console.log(binding.value);
    el.style.backgroundColor = binding.value;
});


new Vue({
    el: '#app',
    data: {
        name: '名無しの権兵衛',
        color: 'yellow'
    }
});
