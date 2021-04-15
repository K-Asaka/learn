#include <stdio.h>

int main(int argc, char** argv) {
	int i, j;
	// 行の表示
	for (i = 0; i < 5; i++) {
		// 列の表示
		for (j = 0; j < 8; j++) {
			if ((i + j) % 2 == 0) {
				printf("□");
			}
			else {
				printf("■");
			}
		}
		// 改行処理
		printf("\n");
	}
	return 0;
}