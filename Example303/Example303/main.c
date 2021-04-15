#include <stdio.h>

int main(int argc, char** argv) {
	int i, j;
	// 行の描画を繰り返す
	for (i = 0; i < 10; i++) {
		// 行の描画
		for (j = 0; j < 10; j++) {
			// iがj以上であれば■、そうでなければ□を表示する
			if (i >= j) {
				printf("■");
			}
			else {
				printf("□");
			}
		}
		// 1行書き終わったら改行させる
		printf("\n");
	}
	return 0;
}