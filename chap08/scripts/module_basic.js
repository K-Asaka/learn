import { getTriangleArea, Member } from './lib/util.js';

console.log(getTriangleArea(10, 2));

let m = new Member('佐藤理央', 25);
m.show();

// モジュールのメタ情報
console.log(import.meta);
