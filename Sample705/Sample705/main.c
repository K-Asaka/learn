#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	FILE* file;
	int i, size;
	// 読み込むデータ
	char* rdata;
	// バイナリデータの読み込み
	file = fopen("I:\\C\\Sample704\\Sample704\\test.bin", "rb");
	if (file == NULL) {
		printf("ファイルオープンに失敗しました。\n");
		return 0;
	}
	// ファイルの最後までシーク
	fseek(file, 0, SEEK_END);
	// ファイルの大きさを取得
	size = ftell(file);
	// メモリのサイズだけ、配列を動的に生成
	rdata = (char*)malloc(sizeof(char) * size);
	// ファイルの最初にポインタを戻す
	fseek(file, 0, SEEK_SET);
	fread(rdata, sizeof(char), size, file);
	// ファイルをクローズ(閉じる)
	fclose(file);
	// 結果を表示
	for (i = 0; i < size; i++) {
		printf("%x ", rdata[i]);
	}
	printf("\n");
	// メモリ解放
	free(rdata);
	return 0;
}