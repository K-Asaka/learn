let app = new Vue ({
    el: '#app',
    data: {
        name: '',           // 入力値
        upperName: ''       // 表示する値（大文字変換後の文字列）
    },
    // 遅延処理用のdelayFuncメソッドを準備
    created: function() {
        let that = this;
        this.delayFunc = _.debounce(this.getUpper, 2000);
        let unwatch = this.$watch('name', function(newValue, oldValue) {
            that.delayFunc();
        });
    },
    // nameの値を大文字に変換したものをupperNameプロパティに設定
    methods: {
        getUpper: function() {
            this.upperName = this.name.toUpperCase();
        }
    }
});
