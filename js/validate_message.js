Vue.use(VeeValidate, {
    locale: 'ja',
    fastExit: false,
    dictionary: {
        ja: {
            messages: {
                required: function (field, param) {
                    return field + 'を入力してください';
                }
            }
        }
    }
});

new Vue({
    el: '#app'
});
