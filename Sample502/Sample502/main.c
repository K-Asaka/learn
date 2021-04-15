#include <stdio.h>

void show(int, int, int);

int main(int argc, char** argv) {
	int a = 100;			// 整数型変数a
	int b = 200;			// 整数型変数b
	int* p = NULL;			// 整数型のポインタ変数p
	p = &a;					// pにaのアドレスを代入
	show(a, b, *p);
	*p = 300;				// *pに値を代入
	show(a, b, *p);
	p = &b;					// pにbのアドレスを代入
	show(a, b, *p);
	*p = 400;				// *pに値を代入
	show(a, b, *p);
	return 0;
}

void show(int n1, int n2, int n3) {
	printf("a = %d b = %d *p = %d\n", n1, n2, n3);
}