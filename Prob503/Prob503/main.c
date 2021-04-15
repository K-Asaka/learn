#include <stdio.h>

// 文字列の中に指定した単語が何文字入っているかをカウントする
void count(char*, char);

int main(int argc, char** argv) {
	char s[256], c;
	printf("英単語を入力:");
	scanf("%s", s);
	// 単語の中に含まれるa～zまでの文字列をカウントする
	for (c = 'a'; c <= 'z'; c++) {
		count(s, c);
	}
	// 単語の中に含まれるA～Zまでの文字列をカウントする
	for (c = 'A'; c <= 'Z'; c++) {
		count(s, c);
	}
	return 0;
}

void count(char* s, char c) {
	// 文字列を探索するポインタ
	char* cp = s;
	// 指定した文字cをカウントする変数
	int count = 0;
	while (*cp != '\0') {
		if (*cp == c) {
			count++;
		}
		cp++;
	}
	// 1文字以上指定の単語が見つかったら数を表示する
	if (count > 0) {
		printf("%c:%d文字\n", c, count);
	}
}