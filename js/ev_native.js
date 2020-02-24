// <input>お嘘を出力するだけのコンポーネント
Vue.component('my-input', {
    template: `<input type="text">`
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
