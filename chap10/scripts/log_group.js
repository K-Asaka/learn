// 親グループを開始
console.group('上位グループ');
for (let i = 0; i < 3; i++) {
    // 子グループを開始
    console.group(`下位グループ ${i}`);
    for (let j = 0; j < 3; j++) {
        console.log(i, j);
    }
    // 子グループを終了
    console.groupEnd();
}
// 親グループを終了
console.groupEnd();
