#include <stdio.h>

int main(int argc, char** argv) {
	int i, j;
	// �s�̕\��
	for (i = 0; i < 5; i++) {
		// ��̕\��
		for (j = 0; j < 8; j++) {
			if ((i + j) % 2 == 0) {
				printf("��");
			}
			else {
				printf("��");
			}
		}
		// ���s����
		printf("\n");
	}
	return 0;
}