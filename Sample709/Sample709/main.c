#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE	4

void show(int*);
int asc(const void*, const void*);

int main(int argc, char** argv) {
	int a[SIZE], i;
	// 乱数の初期化
	srand((unsigned)time(NULL));
	// 1から10までの乱数を発生させる
	for (i = 0; i < SIZE; i++) {
		a[i] = rand() % 10 + 1;
	}
	// 配列の初期値の表示
	show(a);
	qsort((void*)a, SIZE, sizeof(int), asc);
	// ソートの結果の表示
	show(a);
	return 0;
}

// 昇順の並べ替えの判定
int asc(const void* a, const void* b) {
	return *(int*)a - *(int*)b;
}

// 配列の内容の表示
void show(int* array) {
	int i;
	for (i = 0; i < SIZE; i++) {
		printf("%d ", array[i]);
	}
	printf("\n");
}
