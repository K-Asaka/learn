#include <stdio.h>

int main(int argc, char** argv) {
	int a, b;
	printf("1�ڂ̐��l:");
	scanf("%d", &a);
	printf("2�ڂ̐��l:");
	scanf("%d", &b);
	printf("%d + %d = %d\n", a, b, a + b);
	printf("%d - %d = %d\n", a, b, a - b);
	printf("%d * %d = %d\n", a, b, a * b);
	if (b != 0) {
		// 2�ڂ̐���0�łȂ���΁A����Z���s��
		printf("%d / %d = %d �]�� %d\n", a, b, a / b, a % b);
	}
	else {
		// 2�ڂ̐���0�Ȃ�΁A����Z���o���Ȃ��ƕ\��
		printf("0�Ŋ��邱�Ƃ͂ł��܂���\n");
	}
	return 0;
}