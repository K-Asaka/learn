#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE	5

void show(char**);
int dict(const void*, const void*);

int main(int argc, char** argv) {
	// 並べ替える文字列
	char* a[] = { "banana", "apple", "orange", "lemon", "pineapple" };
	// 配列の初期値の表示
	show(a);
	qsort(a, SIZE, sizeof(int), dict);
	// ソートの結果の表示
	show(a);
	return 0;
}

// 辞書順の並べ替えの判定
int dict(const void* a, const void* b) {
	return strcmp(*(const char**)a, *(const char**)b);
}

// 配列の内容の表示
void show(char** array) {
	int i;
	for (i = 0; i < SIZE; i++) {
		printf("%s ", array[i]);
	}
	printf("\n");
}
