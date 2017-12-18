/* 変数定義 ******/
// ジャンケンの手の番号を設定
var GU    = 1;
var CHOKI = 2;
var PA    = 3;

/* 函数定義 ******/
function getHumHand() {
  var hum = prompt('半角数字で1〜3の数字を入力してください。\n\n' + GU + ':グー\n' + CHOKI + ':チョキ\n' + PA + ':パー');
  hum = parseInt(hum, 10);
  if (hum !== GU && hum !== CHOKI && hum !== PA) {
    return undefined;
  } else {
    return hum;
  }
}

/* 実行する処理 ******/
var hum = getHumHand();
console.log(hum);   // この行は動作確認したら消す
