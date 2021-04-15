#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	// ファイルポインタ(出力用)
	FILE* file;
	// ファイルを書き込み用にオープン(開く)
	file = fopen("sample.txt", "w");
	if (file == NULL) {
		// オープンに失敗した場合エラーメッセージを出す
		printf("ファイルが開けません。\n");
		// 異常終了
		return 1;
	}
	// ファイルにデータを書き込む
	fprintf(file, "Hello World.\n");
	fprintf(file, "ABCDEF\n");
	// ファイルをクローズ(閉じる)
	fclose(file);
	return 0;
}