#include <stdio.h>

// �֐�
void func1();
void func2();

int main(int argc, char** argv) {
	void (*fp)() = NULL;		// �֐��|�C���^�ϐ��̐錾
	fp = func1;					// �֐��|�C���^�ϐ�fp��func1����
	fp();						// �֐�fp�����s
	fp = func2;					// �֐��|�C���^�ϐ�fp��func2����
	fp();						// �֐�fp�����s
	return;
}

// �֐�1
void func1() {
	printf("func1\n");
}

// �֐�2
void func2() {
	printf("func2\n");
}