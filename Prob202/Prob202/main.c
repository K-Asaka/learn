#include <stdio.h>

int main(int argc, char** argv) {
	int a, b;
	printf("1つ目の数値:");
	scanf("%d", &a);
	printf("2つ目の数値:");
	scanf("%d", &b);
	printf("%d + %d = %d\n", a, b, a + b);
	printf("%d - %d = %d\n", a, b, a - b);
	printf("%d * %d = %d\n", a, b, a * b);
	if (b != 0) {
		// 2つ目の数が0でなければ、割り算を行う
		printf("%d / %d = %d 余り %d\n", a, b, a / b, a % b);
	}
	else {
		// 2つ目の数が0ならば、割り算が出来ないと表示
		printf("0で割ることはできません\n");
	}
	return 0;
}