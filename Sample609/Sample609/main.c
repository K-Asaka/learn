#include <stdio.h>

void showStatic();

int main(int artc, char** argv) {
	showStatic();
	showStatic();
	return 0;
}

void showStatic() {
	static int s = 100;		// 静的変数の宣言と初期化
	printf("s=%d\n", s);
	s++;					// 静的変数のインクリメント
}
