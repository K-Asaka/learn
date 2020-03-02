// 定義側にはtemplateオプションは不要
Vue.component('my-hello', {
    data: function () {
        return {
            name: 'Vue.js'
        };
    }
})

new Vue({
    el: '#app'
});
