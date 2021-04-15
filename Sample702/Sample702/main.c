#include <stdio.h>
#include <stdlib.h>

#define SIZE	256

int main(int argc, char** argv) {
	// ファイルポインタ(読み込み用)
	FILE* file;
	// 読み込む行
	char line[SIZE];
	// 初期化(空文字列)
	line[0] = '\0';
	// ファイルを読み込み用にオープン(開く)
	file = fopen("I:\\C\\Sample701\\Sample701\\sample.txt", "r");
	if (file == NULL) {
		// 失敗した場合エラーメッセージを出して異常終了
		printf("ファイルが開けません。\n");
		return 1;
	}
	// ファイルのデータを読み込む
	while (fgets(line, SIZE, file) != NULL) {
		printf("%s", line);
	}
	// ファイルをクローズ(閉じる)
	fclose(file);
	return 0;
}