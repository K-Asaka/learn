let msg = 'WINGSでは執筆メンバーを絶賛募集中です！';

console.log(msg.match(/[\p{sc=Hiragana}]+/gu));
console.log(msg.match(/[\p{sc=Katakana}]+/gu));
console.log(msg.match(/[\p{sc=Han}]+/gu));

// 句読点、音引きなども含める場合
console.log('かたかな、カタカナ、漢字。'.match(/[\p{scx=Hiragana}]+/gu));
