#include <stdio.h>

int main(int argc, char** argv) {
	int a;
	printf("�����l�����:");
	// �L�[�{�[�h���琮�������
	scanf("%d", &a);
	// ���͂����l���A���̐����ǂ����𒲂ׂ�
	if (a > 0) {
		// ���̐��������ꍇ�Ɏ��s
		printf("���͂����l�́A���̐��ł��B\n");
	}
	else {
		// 0���A���̐��������ꍇ�Ɏ��s
		printf("���͂����l�́A���̐��ł͂���܂���B\n");
	}
	return 0;
}