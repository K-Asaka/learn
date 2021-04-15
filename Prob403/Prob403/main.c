#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char** argv) {
	int a, b, ans, num;
	// 乱数の初期化
	srand((unsigned)time(NULL));
	// 1から10までの乱数を発生させる
	a = rand() % 10 + 1;
	b = rand() % 10 + 1;
	// 問題の回答を計算する
	ans = a + b;
	// 計算結果を出力
	printf("問題:%d + %d\n", a, b);
	// 正解が出るまで入力を繰り返す無限ループ
	while (1) {
		// キーボードから答えを入力させる
		printf("答えを入力:");
		scanf("%d", &num);
		if (num == ans) {
			// 正解ならbreakでループを抜ける
			printf("正解です\n");
			break;
		}
		// 間違いならループから抜けない
		printf("間違いです\n");
	}
	return 0;
}