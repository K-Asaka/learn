#include <stdio.h>

int main(int argc, char** argv) {
	// 配列とポインタ変数を用意する
	double d[3] = { 0.2, 0.4, 0.6 };
	double* p1 = NULL, * p2 = NULL;
	int i;
	p1 = d;		// p1にdのアドレスを入力
	p2 = d;		// p2にdのアドレスを入力
	for (i = 0; i < 3; i++) {
		printf("%f %f %f\n", *(d + i), p1[i], *p2);
		p2++;		// p2のアドレスをインクリメント
	}
	return 0;
}