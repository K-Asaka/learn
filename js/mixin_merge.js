// tagsオプションのマージルールを定義
Vue.config.optionMergeStrategies.tags = function (toVal, fromVal) {
    if (!toVal) { toVal = []; }
    if (!fromVal) { fromVal = []; }
    return fromVal.concat(toVal);
};

// tagsオプションを持つミックスイン
let tagin = {
    tags: [ 'tag', 'strategy' ]
};

// コンポーネント側もtagsオプションを定義
Vue.component('my-comp', {
    tags: [ 'component', 'sample' ],
    template: `<div>{{ $options.tags }}</div>`,
    mixins: [ tagin ],
});

// Vueインスタンスを生成
let app = new Vue ({
    el: '#app'
});
