let app = new Vue ({
    el: '#app',
    data: {
        author: {
            name: '山田'
        }
    },
    created: function() {
        let that = this;
        // 3000ミリ秒後にプロパティを追加
        this.timer = setTimeout(function() {
            // that.author.name = 'Y.YAMADA';
            //Vue.set(that.author, 'company', 'WINGSプロジェクト');
            // 複数のプロパティを追加する
            that.author = Object.assign({}, that.author, 
                { company: 'WINGSプロジェクト', sex: 'male', age: 18 });
        }, 3000);
    },
    beforeDestroy: function() {
        clearInterval(this.timer);
    }
});
