#include <stdio.h>

void showStatic();

int main(int artc, char** argv) {
	showStatic();
	showStatic();
	return 0;
}

void showStatic() {
	static int s = 100;		// �ÓI�ϐ��̐錾�Ə�����
	printf("s=%d\n", s);
	s++;					// �ÓI�ϐ��̃C���N�������g
}
