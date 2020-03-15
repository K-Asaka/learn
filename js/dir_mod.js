// bind/updateに適用するフック関数
let hook = function (el, binding) {
    if (binding.value === binding.oldValue) { return; }
    // border修飾子で背景ハイライトか枠線ハイライトかを選択
    if (binding.modifiers.border) {
        el.style.borderColor = binding.value;
        el.style.borderStyle = 'solid';
    } else {
        el.style.backgroundColor = binding.value;
    }
};

Vue.directive('highlight', {
    bind: hook,
    update: function (el, binding, vnode, oldVnode) {
        // once修飾子でupdate更新はスキップ
        if (!binding.modifiers.once) {
            hook(el, binding)
        }
    }
});

new Vue({
    el: '#app',
    data: {
        color: 'yellow'
    }
});
