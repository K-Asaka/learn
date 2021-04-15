#include <stdio.h>

int main(int argc, char** argv) {
	int a[] = { 3, 2, 9, 8, 5, 6, 5, 4, 1 };
	int i, sum = 0, max_num, min_num;
	double avg;
	// 仮の最大値をそれぞれa[0]に設定する
	max_num = a[0];
	min_num = a[0];
	// 成分を表示しながら合計値、最大値、最小値を求める
	for (i = 0; i < 9; i++) {
		// 値を表示する
		printf("%d ", a[i]);
		// 暫定の最大値よりもa[i]の値が大きければ更新する
		if (max_num < a[i]) {
			max_num = a[i];
		}
		// 暫定の最小値よりもa[i]の値が小さければ更新する
		if (min_num > a[i]) {
			min_num = a[i];
		}
		// 合計値を計算する
		sum += a[i];
	}
	printf("\n");
	// 合計値をもとに、平均値を計算する
	avg = sum / 9.0;
	// 合計値、平均値、最大値、最小値を表示する
	printf("合計値:%d 平均値:%lf 最大値:%d 最小値:%d\n", sum, avg, max_num, min_num);
	return 0;
}