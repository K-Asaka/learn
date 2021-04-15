#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	int i;
	// int10個分のメモリの確保
	int* a = (int*)malloc(sizeof(int) * 10);
	// 確保したメモリへ成分を代入(配列と同等の扱い);
	for (i = 0; i < 10; i++) {
		a[i] = i + 1;
	}
	// メモリの中身を表示
	for (i = 0; i < 10; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");
	// メモリの解放
	free(a);
	return 0;
}