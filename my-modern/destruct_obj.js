const member = {
    fullname: '佐藤理央',
    sex: 'female',
    age: 18
};
const { fullname, sex, memo = '---' } = member;
console.log(sex, fullname, memo);

// 異なる名前の変数に代入する
const { sex: gender } = member;
console.log(gender);

// 残りのプロパティを取得する
const { fullname: fullname2, ...rest } = member;
console.log(fullname2);
console.log(rest);
