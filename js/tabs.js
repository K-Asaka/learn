Vue.component('tab-member', {
    template: `<div class="tab">
        <p>あなたもWINGSプロジェクトに参加しませんか？<br />
        現在、WINGSプロジェクトでは、ご一緒にお仕事ができる仲間を募集中です。</p>
        <label>名前：<input type="text" v-model="name" /></label>
        <input type="submit" value="登録" />
    </div>`,
    data: function() {
        return {
            name: ''
        }
    }
});
  
Vue.component('tab-new', {
    template: `<div class="tab">
        <h3>「HTML5超入門 」発売！</h3>
        <p>ステップバイステップで学ぶ入門書です。<br />
        HTML5アプリの基礎知識、画面のデザイン、コードの書き方などが理解できます。</p>
    </div>`
});
  
Vue.component('tab-env', {
    template: `<div class="tab">
        <p>開発環境の設定方法を図を交えて詳しく解説します。<br />
        紹介している各モジュールは、日々頻繁にバージョンアップが行われています。</p>
    </div>`
});

new Vue({
    el: '#app',
    methods: {
        // クリック時にタブを切り替え
        onclick: function (tab) {
            this.current = tab;
        }
    },
    computed: {
        // タブ名の取得(「tab-xxxxx」のxxxxxの部分)
        tabNames: function () {
            return Object.keys(this.tabs);
        },
        // 現在表示すべきコンポーネント名を取得
        currentTab: function () {
            return 'tab-' + this.current;
        }
    },
    data: {
        // 表示中のタブ
        current: 'member',
        // 表示すべきタブのリスト(「名前：タブ表示」)
        tabs: {
            'member': 'メンバー募集',
            'new': '新刊紹介',
            'env': '環境構築設定'
        }
    }
});
