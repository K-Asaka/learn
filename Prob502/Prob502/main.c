#include <stdio.h>
#include <string.h>

int main(int argc, char** argv) {
	char s1[256], s2[256], s[512];
	char* cp1 = NULL, * cp2 = NULL;
	printf("1つ目の文字列:");
	scanf("%s", s1);
	printf("2つ目の文字列:");
	scanf("%s", s2);
	// s1をsにコピー
	cp1 = s1;
	cp2 = s;
	while (*cp1 != '\0') {
		*cp2 = *cp1;
		cp1++;
		cp2++;
	}
	// s2をsに追加
	cp1 = s2;
	while (*cp1 != '\0') {
		*cp2 = *cp1;
		cp1++;
		cp2++;
	}
	// 最後に'\0'を追加
	*cp2 = '\0';
	// 結果を表示
	printf("結合した文字列:%s\n", s);
	return 0;
}