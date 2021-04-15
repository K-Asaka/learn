#include <stdio.h>

int main(int argc, char** argv) {
	int i, n, sum = 0;
	for (i = 1; i < argc; i++) {
		// コマンドライン引数の値を整数に変換
		n = atoi(argv[i]);
		// 値を表示
		printf("%d ", n);
		// 合計を計算
		sum += n;
	}
	printf("\n合計:%d\n", sum);
	return 0;
}