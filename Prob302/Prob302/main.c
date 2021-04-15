#include <stdio.h>

int main(int argc, char** argv) {
	int a, b, i, tmp;
	printf("数値を入力:");
	scanf("%d", &a);
	printf("数値を入力:");
	scanf("%d", &b);
	// bよりaの値の方が大きければ、aとbの値を入れ替える
	if (a > b) {
		tmp = a;
		a = b;
		b = tmp;
	}
	// 小さい方の数(a)から、大きい方の数(b)まで1ずつ値を増やす
	for (i = a; i <= b; i++) {
		printf("%d ", i);
	}
	// 改行して終了
	printf("\n");
	return 0;
}