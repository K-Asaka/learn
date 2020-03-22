<template>
    <div>
        <button type="button" v-on:click="onclick">
            {{ this.step }}増加</button>
    </div>
</template>

<script lang="ts">
import { Component, Prop, Emit, Vue } from 'vue-property-decorator';

@Component
export default class MyCounter extends Vue {
    @Prop() private step!: number;
    // カスタムイベント
    // this.$emitメソッドで発生させていたカスタムイベントは@Emitデコレーターで表す
    // @Emitデコレーターの引数を省略した場合、メソッドの名前をケバブケース記法にしたものをイベント名とする。
    // addNumberメソッドであれば、add-numberイベントと見なされる。
    @Emit('plus')
    private onclick() {
        return Number(this.step);
    }
    // JavaScriptの以下の内容と同じ
    // onclick() {
    //      this.$emit('plus', Number(this.step))
    // },
}
</script>
