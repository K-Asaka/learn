#include <stdio.h>

// 関数avgのプロトタイプ宣言
double avg(double, double);

int main(int argc, char** argv) {
	double d1, d2, d3;
	double a = 1.2, b = 3.4, c = 2.7;
	// 同じ計算が3回(関数を呼び出して計算)
	d1 = avg(a, b);
	d2 = avg(4.1, 5.7);
	d3 = avg(c, 2.8);
	printf("d1 = %f, d2 = %f, d3 = %f", d1, d2, d3);
	return 0;
}

// 平均値を求める関数
double avg(double m, double n) {
	// 引数m,nの平均値を求め、rに代入する
	double r = (m + n) / 2.0;
	return r;
}