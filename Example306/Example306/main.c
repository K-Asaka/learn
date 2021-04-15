#include <stdio.h>

int main(int argc, char** argv) {
	// 配列の定義
	int a[] = { 2, -4, 9, 5, 10, 7, -2 };
	int i;
	// 配列の成分をすべて表示
	for (i = 0; i < 7; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");

	// 偶数の成分をすべて表示
	for (i = 0; i < 7; i++) {
		// a[i]を2で割ったあまりが0であれば偶数と判断
		if (a[i] % 2 == 0) {
			printf("%d ", a[i]);
		}
	}
	printf("\n");
	// 正の成分をすべて表示
	for (i = 0; i < 7; i++) {
		if (a[i] > 0) {
			printf("%d ", a[i]);
		}
	}
	printf("\n");
	return 0;
}