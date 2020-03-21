Vue.use(VeeValidate, { locale: 'ja', fastExit: false });

new Vue({
    el: '#app',
    // Vue初期化時に自作ルールを追加
    created: function () {
        this.$validator.extend('ngword', {
            // 検証メッセージを取得
            getMessage(field, args) {
                return field + 'で「' + args + '」は利用できない単語です。';
            },
            validate(value, args) {
                return args.every(function (arg) {
                    return value.indexOf(arg) === -1;
                });
            }
        });
    },
});
