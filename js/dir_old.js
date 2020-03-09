Vue.directive('highlight', function (el, binding, vnode, oldVnode) {
    // 属性値に変化がなければ終了
    if (binding.value === binding.oldValue) { return; }
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
