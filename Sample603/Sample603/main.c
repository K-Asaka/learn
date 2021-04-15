#include <stdio.h>

int max_n(int, int);
int min_n(int, int);

int main(int argc, char** argv) {
	int (*cmp)(int, int) = max_n;		// cmpの宣言とmax_nの代入
	int a = 1, b = 2;
	printf("%dと%dのうち、最大のものは、%d\n", a, b, cmp(a, b));
	cmp = min_n;		// cmpにmin_nを代入
	printf("%dと%dのうち、最大のものは、%d\n", a, b, cmp(a, b));
	return 0;
}

// 最大値を返す関数
int max_n(int m, int n) {
	if (m > n) {
		return m;
	}
	return n;
}

// 最小値を返す関数
int min_n(int m, int n) {
	if (m < n) {
		return m;
	}
	return n;
}
