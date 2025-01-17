'use strict';

let pet = {
	type: 'スノーホワイトハムスター',
	name: 'キラ',
};

// 以下をそれぞれコメント解除して、動作を確認
//Object.preventExtensions(pet);
//Object.seal(pet);
//Object.freeze(pet);

// 既存のプロパティ値を変更
pet.name = '山田きら';

// 既存のプロパティ値を削除
delete pet.type;

// 新規のプロパティを追加
pet.weight = 42;
