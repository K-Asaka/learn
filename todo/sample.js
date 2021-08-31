const myTitle = {
    props: {
        name: {
            type: Object,
            default: function() {
                return {
                    name: 'yamada',
                }
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
