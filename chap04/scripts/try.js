let i = 1;

try {
	i = i * j;		// 例外発生
} catch (e) {
	console.log(`${e.name}: ${e.message}`);
} finally {
	console.log('処理は完了しました。');
}
