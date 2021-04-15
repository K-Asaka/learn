#include <stdio.h>

// プロトタイプ宣言
int max_num(int, int);
void show(int);
void line();

int main(int argc, char** argv) {
	int n1 = 4, n2 = 5;
	line();
	show(n1);
	show(n2);
	printf("2つの数のうち、大きい数は、%dです。\n", max_num(n1, n2));
	line();
	return 0;
}

// 2つの整数のうち最大値を求める関数
int max_num(int a, int b) {
	if (a > b) {
		return a;
	}
	return b;
}

// 数値を表示する関数
void show(int n) {
	printf("数値:%d\n", n);
	return;
}

// 線を引く関数
void line() {
	printf("*********\n");
}
