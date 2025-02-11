let storage = localStorage;

storage.setItem('fruit1', 'りんご');
storage.fruit2 = 'みかん';
storage['fruit3'] = 'ぶどう';

console.log(storage.getItem('fruit1'));
console.log(storage.fruit2);
console.log(storage['fruit3']);


// storage.removeItem('fruit1');
// delete storage.fruit2;
// delete storage['fruit3']
storage.clear();

console.log(storage.getItem('fruit1'));
console.log(storage.fruit2);
console.log(storage['fruit3']);
