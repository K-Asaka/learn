Vue.component('my-input', {
    props: [ 'value' ],
    template: `<label>
        名前：
        <input type="text" v-model="internalValue">
    </label>`,
    // valueプロパティを操作するための算出プロパティを準備
    computed: {
        internalValue: {
            get() {
                return this.value;
            },
            set(newValue) {
                if (this.value !== newValue) {
                    this.$emit('input', newValue);
                }
            }
        }
    }
});

new Vue({
    el: '#app',
    data: {
        message: ''
    }
});
