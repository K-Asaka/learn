#include <stdio.h>

void uppercase_str(char*, char*);

int main(int argc, char** argv) {
	char str1[256], str2[256];
	printf("英単語を入力:");
	scanf("%s", str1);
	uppercase_str(str1, str2);
	printf("変換後の文字列:%s\n", str2);
	return 0;
}

void uppercase_str(char* s1, char* s2) {
	while (*s1 != '\0') {
		// 単語が小文字かどうかを判定する
		if (*s1 >= 'a' && *s1 <= 'z') {
			// 小文字を大文字に変えてコピー
			*s2 = *s1 - 'a' + 'A';
		}
		else {
			// それ以外はそのままコピー
			*s2 = *s1;
		}
		// 次の文字へ移行
		s1++;
		s2++;
	}
	// コピーした文字列の最後に「\0」を挿入
	*s2 = '\0';
}