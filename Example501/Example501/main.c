#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// 配列の中から偶数を表示する
void show_even(int*);

int main(int argc, char** argv) {
	int a[10], i;
	// 乱数の初期化
	srand((unsigned)time(NULL));
	printf("乱数:");
	// 配列に値を代入しながら値を表示する
	for (i = 0; i < 10; i++) {
		a[i] = rand() % 10 + 1;
		printf("%d ", a[i]);
	}
	// 改行
	printf("\n");
	// 偶数を表示
	show_even(a);
	return 0;
}

void show_even(int* a) {
	int i;
	printf("偶数:");
	for (i = 0; i < 10; i++) {
		// 配列の値が偶数であれば、その値を表示する
		if (a[i] % 2 == 0) {
			printf("%d ", a[i]);
		}
	}
	// 改行
	printf("\n");
}