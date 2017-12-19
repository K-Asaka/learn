// アルバムデータの作成
var album = [
  {src: 'img/1.jpg', msg: 'ひとつめ'},
  {src: 'img/2.jpg', msg: 'ふたつめ'},
  {src: 'img/3.jpg', msg: 'みっつめ'},
  {src: 'img/4.jpg', msg: 'よっつめ'},
  {src: 'img/5.jpg', msg: 'いつつめ'},
];

// 最初のデータを表示しておく
var mainImage = document.createElement('img');
mainImage.setAttribute('src', album[0].src);
mainImage.setAttribute('alt', album[0].msg);

var mainMsg = document.createElement('p');
mainMsg.innerText = mainImage.alt;

var mainFlame = document.querySelector('#gallery .main');
mainFlame.insertBefore(mainImage, null);
mainFlame.insertBefore(mainMsg, null);
