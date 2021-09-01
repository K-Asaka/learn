Vue.createApp({
    data: function() {
        return {
            thumbnails: [
                {
                    id: 1,
                    src: "https://placehold.jp/300x300.png"
                },
                {
                    id: 2,
                    src: "https://placehold.jp/3d4070/ffffff/300x300.png"
                },
                {
                    id: 3,
                    src: "https://placehold.jp/b32020/ffffff/300x300.png"
                }
            ],
            selectedThumbnailId: undefined,
            isVisible: false,
            thumbnailHeight: 0,
            isThumbnailLoaded: false
        }
    },
    watch: {
        selectedThumbnailId: function() {
            this.isThumbnailLoaded = false
        }
    },
    computed: {
        currentThumbnail: function() {
            const self = this
            return _.find(self.thumbnails, function(thumb) {
                return thumb.id === self.selectedThumbnailId
            })
        },
        containerStyle: function() {
            return {
                height: this.thumbnailHeight + "px"
            }
        }
    },
    methods: {
        openModal: function(thumb) {
            this.isVisible = true
            this.selectedThumbnailId = thumb.id
        },
        closeModal: function() {
            this.isVisible = false
            this.selectedThumbnailId = undefined
        },
        onLoad: function(event) {
            this.thumbnailHeight = 
                event.target.naturalHeight > 300 ? 300 : event.target.naturalHeight
            this.isThumbnailLoaded = true
        }
    }
}).mount("#app")
