// 個々のバナー
Vue.component('banner-member', {
    template: `<div class="banner">
        <h3>WINGSメンバー募集中！</h3>
        <p>あなたもWINGSプロジェクトに参加しませんか？<br>
        現在、WINGSプロジェクトでは、ご一緒にお仕事ができる仲間を募集中です。</p>
    </div>`
});

Vue.component('banner-new', {
    template: `<div class="banner">
      <h3>新刊「HTML5超入門 」発売</h3>
      <p>ステップバイステップで学ぶ入門書です。<br />
        HTML5アプリの基礎知識、画面のデザイン、コードの書き方などが理解できます。</p>
    </div>`
  });
  
  Vue.component('banner-env', {
    template: `<div class="banner">
      <h3>環境構築設定</h3>
      <p>開発環境の設定方法を図を交えて詳しく解説します。<br />
        紹介している各モジュールは、日々頻繁にバージョンアップが行われています。</p>
    </div>`
  });
  

new Vue({
    el: '#app',
    // 起動時にコンポーネント切り替え用のタイマーを準備
    created: function () {
        let that = this;
        this.interval = setInterval(function () {
            that.current = (that.current + 1) % that.components.length;
        }, 3000);
    },
    // コンポーネント破棄時にタイマーも破棄
    beforeDestroy: function () {
        clearInterval(this.interval);
    },
    computed: {
        // 現在表示すべきコンポーネント名を取得
        currentBanner: function () {
            return 'banner-' + this.components[this.current];
        }
    },
    data: {
        // 表示中のコンポーネント(インデックス)
        current: 0,
        // 表示すべきコンポーネントのリスト
        components: [ 'member', 'new', 'env' ]
    }
});
