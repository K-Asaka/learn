#include <stdio.h>
#include <stdlib.h>

#define SIZE	5

void show(char**);

int main(int argc, char** argv) {
	int i, j;
	char* a[] = { "banana", "apple", "orange", "lemon", "pineapple" };
	show(a);
	// バブルソート(昇順)
	for (i = 0; i < SIZE; i++) {
		for (j = i + 1; j < SIZE; j++) {
			// 順序が逆なら入れ替える
			if (strcmp(a[i], a[j]) > 0) {
				// a[i]とa[j]の入れかえ
				char* tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
	}
	// 結果の表示
	show(a);
	return 0;
}

// 配列の内容の表示
void show(char** array) {
	int i;
	for (i = 0; i < SIZE; i++) {
		printf("%s ", array[i]);
	}
	printf("\n");
}