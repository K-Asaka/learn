const myTitle = {
    props: {
        name: {
            type: String,
            validator: function(value) {
                return value.length > 0
            },
        },
    },
    template: '#title-template',
}

Vue.createApp({
    components: {
        'my-title': myTitle,
    },
}).mount('#app')
