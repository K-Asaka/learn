#include <stdio.h>

int main(int argc, char** argv) {
	// 2�����z��̒�`
	int a[9][9];
	int i, j;
	// ���̕\�����
	for (i = 1; i <= 9; i++) {
		for (j = 1; j <= 9; j++) {
			// �Y���ɂ��邽�߂ɂ́Ai,j�̒l��1������
			a[i - 1][j - 1] = i * j;
		}
	}
	// ���̕\��\������
	for (i = 1; i <= 9; i++) {
		for (j = 1; j <= 9; j++) {
			// �Y�����ɂ��邽�߂ɂ́Ai,j�̒l��1������
			printf("%dx%d=%2d  ", i, j, a[i - 1][j - 1]);
		}
		// 1�s�\�����邲�Ƃɉ��s
		printf("\n");
	}
	return 0;
}