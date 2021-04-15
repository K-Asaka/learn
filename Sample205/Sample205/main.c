#include <stdio.h>

int main(int argc, char** argv) {
	// 使用する変数の定義
	int a;					// 変数の宣言
	int b = 3;				// 宣言と代入を同時に行う
	int add, sub;			// 複数の変数を同時に宣言
	double avg;				// int以外の変数を宣言
	a = 6;					// 代入
	add = a + b;			// a,bの和を求める
	sub = a - b;			// a,bの差を求める
	avg = (a + b) / 2.0;	// a,bの平均値を求める
	printf("%d + %d = %d\n", a, b, add);
	printf("%d - %d = %d\n", a, b, sub);
	printf("%dと%dの平均値:%lf\n", a, b, avg);
	return 0;
}