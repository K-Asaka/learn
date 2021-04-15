#include <stdio.h>

int main(int argc, char** argv) {
	int num;
	printf("1～3の値を入力してください:");
	// キーボードから整数を入力
	scanf("%d", &num);
	// 入力した値が、正の数かどうかを調べる
	if (num == 1) {
		printf("one\n");		// numが1だった場合の処理
	}
	else if (num == 2) {
		printf("two\n");		// numが2だった場合の処理
	}
	else if (num == 3) {
		printf("three\n");		// numが3だった場合の処理
	}
	else {
		printf("不適切な値です。\n");	// それ以外の値だった場合の処理
	}
	return 0;
}