#include <stdio.h>

// my_abs�֐��̃v���g�^�C�v�錾
int my_abs(int);

int main(int argc, char** argv) {
	int n;
	printf("�����l�����:");
	scanf("%d", &n);
	printf("%d�̐�Βl��%d�ł��B\n", n, my_abs(n));
	return 0;
}

// my_abs�֐��̒�`
int my_abs(int a) {
	if (a < 0) {
		// ���̒l�ł���΁A�������t�]������
		return -a;
	}
	// 0�ȏ�̒l�ł���΂��̂܂ܕԂ�
	return a;
}