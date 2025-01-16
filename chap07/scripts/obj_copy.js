let pet = {
	name: 'キラ',
	description: {
		birth: '2014-02-15'
	},
};

// オブジェクトの複製(let copied = { ...pet };でも可)
let copied = Object.assign({}, pet);

console.log(pet);
console.log(copied);
console.log(pet === copied);
