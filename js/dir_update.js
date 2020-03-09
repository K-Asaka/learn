// ディレクティブを定義
// Vue.directive('highlight', {
//     bind: function (el, binding, vnode, oldVnode) {
//         el.style.backgroundColor = binding.value;
//     }
// });

new Vue({
    el: '#app',
    directives: {
        highlight: {
            bind: function (el, binding, vnode, oldVnode) {
                el.style.backgroundColor = binding.value;
            }
        }
    },
    data: {
        color: 'yellow'
    }
});
