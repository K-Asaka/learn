#include <stdio.h>

int main(int argc, char** argv) {
	int num;
	printf("1�`3�̒l����͂��Ă�������:");
	// �L�[�{�[�h���琮�������
	scanf("%d", &num);
	// ���͂����l���A���̐����ǂ����𒲂ׂ�
	switch (num) {
	case 1:
		printf("one\n");		// num��1�������ꍇ�̏���
		break;
	case 2:
		printf("two\n");		// num��2�������ꍇ�̏���
		break;
	case 3:
		printf("three\n");		// num��3�������ꍇ�̏���
		break;
	default:
		// ����ȊO�̒l�����͂��ꂽ�ꍇ�̏���
		printf("�s�K�؂Ȓl�ł��B\n");
		break;
	}
	return 0;
}