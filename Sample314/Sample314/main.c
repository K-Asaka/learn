#include <stdio.h>

// 2次元配列
int main(int argc, char** argv) {
	// 2次元配列の初期化
	int n[3][5] = {
		{0, 1, 2, 3, 4},
		{1, 2, 3, 4, 5},
		{2, 3, 4, 5, 6}
	};
	int i, j;
	for (i = 0; i < 3; i++) {
		for (j = 0; j < 5; j++) {
			printf("n[%d][%d]=%d ", i, j, n[i][j]);
		}
		printf("\n");
	}
	return 0;
}