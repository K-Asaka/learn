#include <stdio.h>

// 関数
void func1();
void func2();

int main(int argc, char** argv) {
	void (*fp)() = NULL;		// 関数ポインタ変数の宣言
	fp = func1;					// 関数ポインタ変数fpにfunc1を代入
	fp();						// 関数fpを実行
	fp = func2;					// 関数ポインタ変数fpにfunc2を代入
	fp();						// 関数fpを実行
	return;
}

// 関数1
void func1() {
	printf("func1\n");
}

// 関数2
void func2() {
	printf("func2\n");
}