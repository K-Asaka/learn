#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE	4

void show(int*);
void swap(int*, int*);

int main(int argc, char** argv) {
	int a[SIZE], i, j;
	// 乱数の初期化
	srand((unsigned)time(NULL));
	// 1から10までの乱数を発生させる
	for (i = 0; i < SIZE; i++) {
		a[i] = rand() % 10 + 1;
	}
	// 配列の表示
	show(a);
	// バブルソート(降順)
	for (i = 0; i < SIZE; i++) {
		for (j = 0; j < SIZE - 1; j++) {
			// 順序が逆なら入れ替える
			if (a[j] < a[j + 1]) {
				// a[j]とa[j + 1]の入れ替え
				swap(&a[j], &a[j + 1]);
			}
			// 途中経過の表示
			show(a);
		}
	}
	return 0;
}

// 配列の内容の表示
void show(int* array) {
	int i;
	for (i = 0; i < SIZE; i++) {
		printf("%d ", array[i]);
	}
	printf("\n");
}

// 値の交換
void swap(int* num1, int* num2) {
	int temp = *num1;
	*num1 = *num2;
	*num2 = temp;
}
