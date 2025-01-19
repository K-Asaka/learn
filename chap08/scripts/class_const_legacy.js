let Member = function(name, age) {
	this.name = name;
	this.age = age;
};

let m = new Member('佐藤理央', 25);
let m1 = Member();
console.log(typeof m);
console.log(typeof m1);
