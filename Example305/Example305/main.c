#include <stdio.h>

int main(int argc, char** argv) {
	int num = 0;
	while (1) {
		printf("���̐�������͂��Ă�������:");
		// ���������
		scanf("%d", &num);
		if (num > 0) {
			// ���̐����Ȃ炻�̂܂ܕ\��
			printf("%d\n", num);
		}
		else {
			// ���l�����łȂ���΃��b�Z�[�W��\�����ă��[�v���甲����
			printf("���̐����ł͂���܂���\n");
			break;
		}
	}
	return 0;
}