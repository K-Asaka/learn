#include <stdio.h>

int main(int argc, char** argv) {
	int dice;
	printf("サイコロの目(1-6):");
	// キーボードから整数を入力
	scanf("%d", &dice);
	// 入力した値が、偶数か奇数かを調べる
	switch (dice) {
	case 1:
	case 3:
	case 5:
		printf("奇数です。\n");
		break;
	case 2:
	case 4:
	case 6:
		printf("偶数です。\n");
		break;
	default:
		printf("範囲外です。\n");
		break;
	}
	return 0;
}