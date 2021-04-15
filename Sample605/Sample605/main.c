#include <stdio.h>

int main(int argc, char** argv) {
	// 整数型変数の宣言
	int a = 10;
	// ポインタ変数の宣言
	int* p = &a;
	// ポインタのポインタ
	int** pp = &p;
	printf("a=%d &a=0x%x\n", a, &a);
	printf("*p=%d p=0x%x &p=0x%x\n", *p, p, &p);
	printf("*pp=0x%x pp=0x%x\n", *pp, pp);
	return 0;
}