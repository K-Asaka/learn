Vue.component('my-book', {
    data: function () {
        return {
            book: {
                isbn: '978-4-8222-5389-9',
                title: '作って楽しむプログラミング HTML5超入門',
                price: 2000,
                publish: '日経BP'
            }
        };
    },
    template: `<div>
        <slot v-bind:book="book">{{ book.title }} ({{ book.publish}} ) </slot>
    </div>`
});

new Vue({
    el: '#app',
});
