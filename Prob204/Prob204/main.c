#include <stdio.h>

int main(int argc, char** argv) {
	int month;
	printf("��(1�`12)�̒l����͂��Ă�������:");
	// �������
	scanf("%d", &month);
	switch (month) {
	case 12:
	case 1:
	case 2:
		printf("�~�ł�\n");
		break;
	case 3:
	case 4:
	case 5:
		printf("�t�ł�\n");
		break;
	case 6:
	case 7:
	case 8:
		printf("�Ăł�\n");
		break;
	case 9:
	case 10:
	case 11:
		printf("�H�ł�\n");
		break;
	default:
		// 1�`12�ȊO�̒l�������ꍇ
		printf("�s�K�؂Ȓl�ł�\n");
		break;
	}
	return 0;
}