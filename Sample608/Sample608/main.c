#include <stdio.h>

int g = 10;		// �O���ϐ��̐錾

void showExterns();

int main(int argc, char** argv) {
	// �l�̕\��
	printf("main�֐�:g=%d\n", g);
	showExterns();
	return 0;
}

void showExterns() {
	printf("showExterns�֐�:g=%d\n", g);
}