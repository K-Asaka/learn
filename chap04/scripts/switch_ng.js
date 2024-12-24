let x = '0';

switch(x) {
  case 0:
	// この部分は実行されない
	console.log('0です。');
	break;
  case '0':
	console.log('文字列の0です。');
	break;
}

