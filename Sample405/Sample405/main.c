#include <stdio.h>

// �O���[�o���ϐ�
int global = 10;

// �v���g�^�C�v�錾
void func1(double, int);
void func2();

int main(int argc, char** argv) {
	double a = 123.41;
	int b = 100;
	printf("main������\n");
	printf("global=%d\n", global);
	printf("a=%f b=%d\n", a, b);
	printf("******************\n");
	// func1���Ăяo��
	func1(3.1, 4);
	// func2���Ăяo��
	func2();
	return 0;
}

void func1(double a, int b) {
	printf("func1������\n");
	printf("global=%d\n", global);
	printf("a=%f b=%d\n", a, b);
	printf("******************\n");
}

void func2() {
	double a = -4.1;
	int b = 2;
	printf("func2������\n");
	printf("global=%d\n", global);
	printf("a=%f b=%d\n", a, b);
	printf("******************\n");
}
