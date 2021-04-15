#include <stdio.h>

int main(int argc, char** argv) {
	int num = 0;
	while (1) {
		printf("正の整数を入力してください:");
		// 整数を入力
		scanf("%d", &num);
		if (num > 0) {
			// 正の整数ならそのまま表示
			printf("%d\n", num);
		}
		else {
			// 数値が正でなければメッセージを表示してループから抜ける
			printf("正の整数ではありません\n");
			break;
		}
	}
	return 0;
}