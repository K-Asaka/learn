#include <stdio.h>

int main(int argc, char** argv) {
	// ポインタをNULLで初期化
	int* p = NULL;
	// アドレスを指定しないまま値を代入
	*p = 1;
	return 0;
}