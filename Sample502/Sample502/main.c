#include <stdio.h>

void show(int, int, int);

int main(int argc, char** argv) {
	int a = 100;			// �����^�ϐ�a
	int b = 200;			// �����^�ϐ�b
	int* p = NULL;			// �����^�̃|�C���^�ϐ�p
	p = &a;					// p��a�̃A�h���X����
	show(a, b, *p);
	*p = 300;				// *p�ɒl����
	show(a, b, *p);
	p = &b;					// p��b�̃A�h���X����
	show(a, b, *p);
	*p = 400;				// *p�ɒl����
	show(a, b, *p);
	return 0;
}

void show(int n1, int n2, int n3) {
	printf("a = %d b = %d *p = %d\n", n1, n2, n3);
}