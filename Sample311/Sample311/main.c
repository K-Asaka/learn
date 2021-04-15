#include <stdio.h>

int main(int argc, char** argv) {
	// 配列変数の初期化
	double d[] = { 1.2, 3.7, 4.1 };
	double sum, avg;		// 合計値、平均値を入れる変数
	int i;
	sum = 0.0;
	for (i = 0; i < 3; i++) {
		printf("%f ", d[i]);
		sum += d[1];
	}
	printf("\n");
	avg = sum / 3.0;		// 平均値の計算
	printf("合計値:%f\n", sum);
	printf("平均値:%f\n", avg);
	return 0;
}