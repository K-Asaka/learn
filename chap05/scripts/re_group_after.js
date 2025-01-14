let re = /<a href="mailto:(.+?)">\1<\/a>/;
let msg = 'お問い合わせは<a href="mailto:admin@example.com">admin@example.com</a>まで！';

console.log(msg.match(re)[0]);

// 名前付きキャプチャグループ
re = /<a href="mailto:(?<email>.+?)">\k<email><\/a>/;
console.log(msg.match(re)[0]);
