Vue.directive('markdown', function (el, binding, vnode, oldVnode) {
    // markdown文字列をHTML文字列に変換
    el.innerHTML = marked(el.textContent, binding.value);
});

new Vue({
    el: '#app',
    data: {
        options: {
            gfm: true,      // GitHub仕様のmarkdownを有効化
            breaks: true,   // 単一改行を<br>タグにするか
            xhtml: true,    // 空タグを～/>に
        }
    },
});
