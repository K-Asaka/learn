#include <stdio.h>

// 2次元配列
int main(int argc, char** argv) {
	int a[3][4];
	int m, n;
	// 2次元配列に値を代入
	for (m = 0; m < 3; m++) {
		for (n = 0; n < 4; n++) {
			a[m][n] = m * n;
		}
	}
	// 成分の表示
	for (m = 0; m < 3; m++) {
		for (n = 0; n < 4; n++) {
			printf("%d x %d = %d ", m, n, a[m][n]);
		}
		printf("\n");
	}
	return 0;
}