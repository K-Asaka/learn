let getTriangleArea = (base, height) => {
	return base * height / 2;
};

console.log(getTriangleArea(10, 4));

// 関数本体が1文の場合
getTriangleArea = (base, height) => base * height / 2;
console.log(getTriangleArea(10, 4));

// 引数が1個の場合
let getCircleArea = radius => (radius ** 2) * Math.PI;
console.log(getCircleArea(5));

// 引数がない場合、カッコは省略できない
let show = () => console.log('こんにちは、世界！');
show();

let doSomething = () => 1;

// 意図しない戻り値が発生する
let func = () => { doSomething() };
let func2 = () => doSomething();
console.log('func=' + func());
console.log('func2=' + func2());

// voidを冠する
func2 = () => void doSomething();
console.log('func2=' + func2());

// オブジェクトリテラルが正しく認識されない
let func3 = () => { hoge: 'ほげ'}
let func4 = () => ({ hoge: 'ほげ' });
console.log(func3());
console.log(func4());
