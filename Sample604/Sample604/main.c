#include <stdio.h>

// 関数ポインタを引数としてとる関数
void funcp(int (*)(int), int n);
// 関数ポインタに使う関数
int dbl(int);
int hlf(int);

int main(int argc, char** argv) {
	funcp(dbl, 8);		// 引数として、関数を渡す
	funcp(hlf, 8);		// 引数として、関数を渡す
	return 0;
}

// 引数として与えた関数を実行して結果も表示する
void funcp(int (*f)(int), int n) {
	printf("引数:%d 結果%d\n", n, f(n));
}

// 引数を倍にして返す
int dbl(int n) {
	return n * 2;
}

// 引数を半分にして返す
int hlf(int n) {
	return n / 2;
}
