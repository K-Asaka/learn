#include <stdio.h>

int main(int argc, char** argv) {
	int i, j;
	// �s�̕`����J��Ԃ�
	for (i = 0; i < 10; i++) {
		// �s�̕`��
		for (j = 0; j < 10; j++) {
			// i��j�ȏ�ł���΁��A�����łȂ���΁���\������
			if (i >= j) {
				printf("��");
			}
			else {
				printf("��");
			}
		}
		// 1�s�����I���������s������
		printf("\n");
	}
	return 0;
}