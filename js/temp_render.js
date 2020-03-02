Vue.component('my-loading', {
    props: [ 'type' ],
    render: function (h) {
        // type属性に応じて戻り値を切り替え
        switch (this.type) {
            case 'text':
                return h('p', '...Now Loading...');
            case 'image':
                return h('img', {
                    attrs: {
                        src: 'images/loading.gif',
                        alt: 'loading'
                    }
                });
            default:
                console.error('type属性はimage、textいずれかで設定してください');
                return null;
        }
    }
});

new Vue({
    el: '#app'
});
