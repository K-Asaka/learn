Vue.component('my-hello', {
    // プロパティを定義
    props: {
        yourName: {
            type: String,
            required: true
        }
    },
    template: `<div>こんにちは、{{ yourName }}さん！</div>`,
})

new Vue({
    el: '#app'
});
