#include <stdio.h>

int main(int argc, char** argv) {
	int num1, num2;
	// 2つの数を入力
	printf("num1=");
	scanf("%d", &num1);
	printf("num2=");
	scanf("%d", &num2);
	// 両方とも正の数かどうかを判定
	if (num1 > 0) {
		if (num2 > 0) {
			printf("num1,num2ともに正の数です。\n");
		}
		else {
			printf("num1,num2のどちらかが正の数ではありません。\n");
		}
	}
	else {
		printf("num1,num2のどちらかが正の数ではありません。\n");
	}
	return 0;
}