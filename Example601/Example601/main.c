#include <stdio.h>

int main(int argc, char** argv) {
	int length, i;
	int* array = NULL;
	printf("配列の長さ:");
	scanf("%d", &length);
	// 配列の長さが正の値かどうかをチェック
	if (length <= 0) {
		printf("配列の長さは1以上にしてください。\n");
		return 0;
	}
	// 生成した長さの配列を生成
	array = (int*)malloc(sizeof(int) * length);
	if (array == 0) {
		// メモリの生成に失敗した場合には、終了
		printf("メモリの生成に失敗しました。\n");
		return 0;
	}
	// 乱数を代入
	for (i = 0; i < length; i++) {
		array[i] = rand() % 10 + 1;
	}
	// 乱数の値を表示
	printf("生成した配列:");
	// 配列の値を表示
	for (i = 0; i < length; i++) {
		printf("%d ", array[i]);
	}
	printf("\n");
	// メモリの解放
	free(array);
	return 0;
}