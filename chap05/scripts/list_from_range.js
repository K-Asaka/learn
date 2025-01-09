const BEGIN = 10;	// 開始値
const END = 20;		// 終了値
const STEP = 3;		// 増分

let list = Array.from(
	{ length: (END - BEGIN) / STEP + 1 },
	function(v, i) {
		return BEGIN + (i * STEP)
	}
);

console.log(list);
