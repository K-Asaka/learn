import { MyStorage } from './MyStorage.js'

let storage = new MyStorage('JSSample');
storage.setItem('hoge', 'ほげ');
console.log(storage.getItem('hoge'));
storage.save();
