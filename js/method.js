new Vue({
    el: '#app',
    data: {
        email: 'MethodSample@example.local'
    },
    // emailプロパティの値を加工するlocalEmailメソッドを定義
    methods: {
        localEmail: function() {
            return this.email.split('@')[0].toLowerCase();
        }
    }
});
