#include <stdio.h>

// �v���g�^�C�v�錾
int max_num(int, int);
void show(int);
void line();

int main(int argc, char** argv) {
	int n1 = 4, n2 = 5;
	line();
	show(n1);
	show(n2);
	printf("2�̐��̂����A�傫�����́A%d�ł��B\n", max_num(n1, n2));
	line();
	return 0;
}

// 2�̐����̂����ő�l�����߂�֐�
int max_num(int a, int b) {
	if (a > b) {
		return a;
	}
	return b;
}

// ���l��\������֐�
void show(int n) {
	printf("���l:%d\n", n);
	return;
}

// ���������֐�
void line() {
	printf("*********\n");
}
