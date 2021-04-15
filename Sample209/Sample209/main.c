#include <stdio.h>

int main(int argc, char** argv) {
	int a;
	printf("整数値を入力:");
	// キーボードから整数を入力
	scanf("%d", &a);
	// 入力した値が、正の数かどうかを調べる
	if (a > 0) {
		// 正の数だった場合に実行
		printf("入力した値は、正の数です。\n");
	}
	else {
		// 0か、負の数だった場合に実行
		printf("入力した値は、正の数ではありません。\n");
	}
	return 0;
}