#include <stdio.h>

int main(int argc, char** argv) {
	int num1, num2;
	// 2�̐������
	printf("num1=");
	scanf("%d", &num1);
	printf("num2=");
	scanf("%d", &num2);
	// �����Ƃ����̐����ǂ����𔻒�
	if (num1 > 0 && num2 > 0) {
		printf("num1,num2�Ƃ��ɐ��̐��ł��B\n");
	}
	else {
		printf("num1,num2�ɐ��ł͂Ȃ���������܂��B\n");
	}
	return 0;
}