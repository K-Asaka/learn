<template>
  <div>
    <p>{{ hoge("こんにちは") }}</p>
    <p>{{ localEmail }}</p>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
// メソッド(methodsオプション)
// コンポーネントのメソッド宣言(methodsオプション)は、TypeScriptでもメソッドとして扱う
export default class MyHello extends Vue {
  private email: string = 'sample@example.local';

  private hoge(value: string): string {
    return `**${value}**`;
  }

  // 算出プロパティ
  // ゲッターやセッターとして表す。セッターであれば「set localEmail(value: string): void { ... }」のように表す。
  get localEmail(): string {
    return this.email.split('@')[0].toLowerCase();
  }
}
</script>
