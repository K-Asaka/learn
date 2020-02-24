// <input>お嘘を出力するだけのコンポーネント
Vue.component('my-input', {
    template: `<label>名前：</label><input type="text"></label>`
});

new Vue({
    el: '#app',
    methods: {
        // フォーカス時にイベント情報をログ表示
        onfocus: function (e) {
            console.log(e);
        }
    }
});
