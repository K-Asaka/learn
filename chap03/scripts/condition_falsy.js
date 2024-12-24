let value = '';
//value = value ? value : '既定値';
//value ||= '既定値';
// ゼロ、空文字列などを除外できない場合は??=を使う
//value ??= '既定値';

console.log(value);
console.log(value || '既定値');
console.log(value ?? '既定値');
