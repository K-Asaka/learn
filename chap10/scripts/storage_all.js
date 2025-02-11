let storage = localStorage;
storage.setItem('fruit1', 'りんご');
storage.fruit2 = 'みかん';
storage['fruit3'] = 'ぶどう';

for (let i = 0; i < storage.length; i++) {
    let key = storage.key(i);
    console.log(`${key}: ${storage[key]}`);
}
