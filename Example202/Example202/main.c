#include <stdio.h>

int main(int argc, char** argv) {
	int num;
	printf("�����l�����:");
	scanf("%d", &num);
	if (num % 2 == 0) {
		printf("%d�͋����ł��B\n", num);
	}
	else {
		printf("%d�͊�ł��B\n", num);
	}
	return 0;
}