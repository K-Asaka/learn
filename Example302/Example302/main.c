#include <stdio.h>

int main(int argc, char** argv) {
	int i, num;
	printf("���̐�����͂��Ă�������:");
	// �L�[�{�[�h����J��Ԃ��̉񐔂���͂�����
	scanf("%d", &num);
	if (num > 0) {
		// ���̐������͂��ꂽ�ꍇ
		for (i = 1; i <= num; i++) {
			printf("%d ", i);
		}
		// ������\����ɉ��s
		printf("\n");
	}
	else {
		// ���͂��ꂽ�l�����̐��ł͂Ȃ������ꍇ
		printf("���͂����l�͕s�K�؂ł��B\n");
	}
	return 0;
}