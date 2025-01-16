function showDialog({
	content = '',
	title = 'My Dialog',
	width = 100,
	height = 100,
	position = 'center',
	modal = false
}) {
	// 引数の内容を表示
	console.log(`content: ${content}`);
	console.log(`title: ${title}`);
	console.log(`width: ${width}`);
	console.log(`height: ${height}`);
	console.log(`position: ${position}`);
	console.log(`modal: ${modal}`);
}

showDialog({
	content: 'ダイアログです',
	modal: true,
});
