// 与えられた文字列をエスケープ処理
function escapeHtml(str) {
	if (!str) { return ''; }
	str = str.replaceAll(/&/g, '&amp;');
	str = str.replaceAll(/</g, '&lt;');
	str = str.replaceAll(/>/g, '&gt;');
	str = str.replaceAll(/"/g, '&quot;');
	str = str.replaceAll(/'/g, '&#39;');
	return str;
}

// 分解されたtemplatesとvaluesを順に連結(valuesはescapeHtml関数でエスケープ)
function e(templates, ...values) {
	let result = '';
	for (let [i, temp] of templates.entries()) {
		result += temp + escapeHtml(values[i]);
	}
	return result;
}

// テンプレート文字列をエスケープ処理
let name = '<"Mario" & \'Luigi\'>';
console.log(e`こんにちは、${name}さん！`);

// 標準のタグ関数
console.log(`C:\\data\\jsbook\\chap06`);
console.log(String.raw`C:\data\jsbook\chap06`);
let file = 'index.html';
console.log(String.raw`${file}はC:\data\jsbook\chap06配下`);
