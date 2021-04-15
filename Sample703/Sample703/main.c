#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	// ファイルポインタ(読み込み用)
	FILE* file;
	// 読み込む文字のコード
	int c;
	// ファイルを読み込み用にオープン(開く)
	file = fopen("i:\\C\\Sample701\\Sample701\\sample.txt", "r");
	if (file == NULL) {
		// オープンに失敗した場合異常終了
		printf("ファイルが開けません。\n");
		return 1;
	}
	// ファイルのデータ読み込む
	while ((c = fgetc(file)) != EOF) {
		printf("%c", (char)c);
	}
	// ファイルをクローズする
	fclose(file);
	return 0;
}