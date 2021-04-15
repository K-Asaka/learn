#include <stdio.h>

void show(char**);

int main(int argc, char** argv) {
	// 文字列の配列
	char* s[] = { "Taro", "Hanako", "Tom" };
	int i;
	printf("** sの配列として表示 **\n");
	for (i = 0; i < 3; i++) {
		printf("%s\n", s[i]);
	}
	// 関数の引数として文字列の配列を渡す
	show(s);
	return 0;
}

// 複数の文字列を表示する
void show(char** pps) {
	int i;
	printf("** show関数として表示 **\n");
	for (i = 0; i < 3; i++) {
		printf("%s\n", pps[i]);
	}
}