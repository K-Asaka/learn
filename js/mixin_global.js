Vue.mixin({
    // コンポーネント生成時の処理
    created: function () {
        // データオブジェクトからtitle、keyword、descriptionを抽出
        let { title, keyword, description } = this.$data;
        // title/keyword/descriptionが設定されていれば、それぞれ設定
        if (title) { document.title = title; }
        if (keyword) {
            document.querySelector("meta[name='keyword']").setAttribute('content', keyword);
        }
        if (description) {
            document.querySelector("meta[name='description']").setAttribute('content', description);
        }
    }
});

Vue.component('my-mix', {
    template: `<div>Global Mix-In!!</div>`,
    data: function () {
        return {
            title: 'グローバルミックスイン',
            keyword: 'mixin, vuejs, component',
            description: 'アプリ全体に適用されるミックスインの例です。'
        };
    }
});

// Vueインスタンスを生成
let app = new Vue ({
    el: '#app'
});
