// Animalクラスと、これを継承したHamsterクラスを準備
class Animal {}
class Hamster extends Animal {}

let ani = new Animal();
let ham = new Hamster();
console.log(ani.constructor === Animal);
console.log(ham.constructor === Animal);
console.log(ham.constructor === Hamster);

// 指定したクラスのインスタンスであるかを判定する
console.log(ham instanceof Animal);
console.log(ham instanceof Hamster);

// 参照しているプロトタイプを確認する
console.log(Hamster.prototype.isPrototypeOf(ham));
console.log(Animal.prototype.isPrototypeOf(ham));
console.log(Object.prototype.isPrototypeOf(ham));
