#include <stdio.h>
#include <string.h>

int main(int argc, char** argv) {
	char s1[256], s2[256], s[512];
	printf("1つ目の文字列:");
	scanf("%s", s1);
	printf("2つ目の文字列:");
	scanf("%s", s2);
	// s1をsにコピー
	strcpy(s, s1);
	// s2をsに追加
	strcat(s, s2);
	// 結果を表示
	printf("結合した文字列:%s\n", s);
	return 0;
}