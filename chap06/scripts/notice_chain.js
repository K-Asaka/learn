function checkScope() {
	let x = y = 13;
	// let x = (y = 13);となるため、yはグローバル変数
}

checkScope();
console.log(y);
