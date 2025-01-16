let x = 0;

// switch (x) {
// 	case 0:
// 		let value = 'x:0';
// 		break;
// 	case 1:
// 		let value = 'x:1';	// 変数名の重複
// 		break;
// }

// 対処方法(let宣言をブロックの外に移動する)
let value;
switch (x) {
	case 0:
		value = 'x:0';
		break;
	case 1:
		value = 'x:1';
		break;
}

// 対処方法(case句をブロックでくくる)
switch (x) {
	case 0: {
		let value = 'x:0';
		break;
	}
	case 1: {
		let value = 'x:1';
		break;
	}
}
