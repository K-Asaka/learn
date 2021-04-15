#include <stdio.h>

int main(int argc, char** argv) {
	int i, num;
	printf("正の数を入力してください:");
	// キーボードから繰り返しの回数を入力させる
	scanf("%d", &num);
	if (num > 0) {
		// 正の数が入力された場合
		for (i = 1; i <= num; i++) {
			printf("%d ", i);
		}
		// 数字を表示後に改行
		printf("\n");
	}
	else {
		// 入力された値が正の数ではなかった場合
		printf("入力した値は不適切です。\n");
	}
	return 0;
}