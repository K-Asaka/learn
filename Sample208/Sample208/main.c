#include <stdio.h>

int main(int argc, char** argv) {
	int a;
	printf("���l�����:");
	// �L�[�{�[�h���琮�������
	scanf("%d", &a);
	// ���͂����l���A���̐����ǂ����𒲂ׂ�
	if (a > 0) {
		printf("���͂����l�́A���̐��ł��B\n");		// ���̐��������ꍇ�Ɏ��s
	}
	return 0;
}