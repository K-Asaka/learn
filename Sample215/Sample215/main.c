#include <stdio.h>

int main(int argc, char** argv) {
	int dice;
	printf("�T�C�R���̖�(1-6):");
	// �L�[�{�[�h���琮�������
	scanf("%d", &dice);
	// ���͂����l���A����������𒲂ׂ�
	switch (dice) {
	case 1:
	case 3:
	case 5:
		printf("��ł��B\n");
		break;
	case 2:
	case 4:
	case 6:
		printf("�����ł��B\n");
		break;
	default:
		printf("�͈͊O�ł��B\n");
		break;
	}
	return 0;
}