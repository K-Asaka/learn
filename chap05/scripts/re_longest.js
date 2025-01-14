let str = '<p><strong>お問い合わせ</strong>はこちら<a href="contact.html"><img src="faq.jpg"></img></a></p>';
let re = /<.+>/g;
let result = str.match(re);

for (let i = 0; i < result.length; i++) {
	console.log(result[i]);
}

re = /<.+?>/g;
result = str.match(re);
console.log("-----");

// 最短一致
for (let i = 0; i < result.length; i++) {
	console.log(result[i]);
}
