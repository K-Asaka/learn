Vue.component('my-input', {
    props: [ 'name' ],
    // 紐付け先をnameプロパティ／changeイベントに変更
    model: {
        prop: 'name',
        event: 'change'
    },
    template: `<label>
        名前：
        <input type="text" v-bind:value="name" v-on:input="$emit('change', $event.target.value)">
    </label>`
});

new Vue({
    el: '#app',
    data: {
        message: ''
    }
});
