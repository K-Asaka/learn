let str = '𠮟ります';
console.log(str.match(/^.ります$/gu));

// uを外すとサロゲートペアが正しく認識されない
console.log(str.match(/^.ります$/g));
