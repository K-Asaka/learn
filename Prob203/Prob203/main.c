#include <stdio.h>

int main(int argc, char** argv) {
	int month;
	printf("��(1�`12)�̒l����͂��Ă�������:");
	// �������
	scanf("%d", &month);
	if (month == 12 || month == 1 || month == 2) {
		// 12,1,2�������ꍇ
		printf("�~�ł�\n");
	}
	else if (month == 3 || month == 4 || month == 5) {
		// 3,4,5�������ꍇ
		printf("�t�ł�\n");
	}
	else if (month == 6 || month == 7 || month == 8) {
		// 6,7,8�������ꍇ
		printf("�Ăł�\n");
	}
	else if (month == 9 || month == 10 || month == 11) {
		// 9,10,11�������ꍇ
		printf("�H�ł�\n");
	}
	else {
		// 1�`12�ȊO�̒l�������ꍇ
		printf("�s�K�؂Ȓl�ł�\n");
	}
	return 0;
}