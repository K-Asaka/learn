#include <stdio.h>

// my_abs関数のプロトタイプ宣言
int my_abs(int);

int main(int argc, char** argv) {
	int n;
	printf("整数値を入力:");
	scanf("%d", &n);
	printf("%dの絶対値は%dです。\n", n, my_abs(n));
	return 0;
}

// my_abs関数の定義
int my_abs(int a) {
	if (a < 0) {
		// 負の値であれば、符号を逆転させる
		return -a;
	}
	// 0以上の値であればそのまま返す
	return a;
}