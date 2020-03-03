Vue.component('my-random', {
    // 関数型コンポーネントを有効化
    functional: true,
    props: [ 'min', 'max' ],
    render: function (h, context) {
        let min = context.props.min;
        let max = context.props.max;
        // min～maxの範囲の乱数を生成
        let result = Math.floor(Math.random() * (max - min + 1) + min);
        // createElementメソッドで<p>要素を生成
        return h('p', result);
    }
});

new Vue({
    el: '#app'
});
