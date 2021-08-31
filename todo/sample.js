Vue.createApp({
    data: function() {
        return {
            isShow: false,
        }
    },
    methods: {
        beforeEnter: function(el) {
            //　要素が出現・表示される前の状態をここで定義します
        },
        enter: function(el, done) {
            // elに出現・表示されるアニメーションを実行します
            // アニメーションが完了したらdoneコールバックを呼び出します
        },
        afterEnter: function(el) {
            // 要素が出現・表示された後の状態を定義します
        },
        enterCancelled: function(el) {
            // 要素が出現・表示するアニメーションをキャンセルされたときの状態を定義します
        },
        beforeLeave: function(el) {
            // 要素が消滅・非表示される前の状態をここで定義します
        },
        leave: function(el, done) {
            // elに消滅・非表示されるアニメーションを実行します
            // アニメーションが完了したらdoneコールバックを呼び出します
        },
        afterLeave: function(el) {
            // 要素が消滅・非表示されてアニメーション終了時に実行されます
        },
        leaveCancelled: function(el) {
            // 要素が消滅・非表示するアニメーションをキャンセルされたときの状態を定義します
        },
    },
}).mount('#app')
