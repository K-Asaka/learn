#include <stdio.h>

// �������[�v����break���Ŕ����o��
int main(int argc, char** argv) {
	int num;
	printf("���̒l�ŁA���[�v���甲���܂�");
	while (1) {
		printf("���l�����:");
		scanf("%d", &num);
		if (num < 0) {
			// ���[�v���甲����
			break;
		}
	}
	printf("�I��\n");
	return 0;
}