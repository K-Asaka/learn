#include <stdio.h>

// �֐��|�C���^�������Ƃ��ĂƂ�֐�
void funcp(int (*)(int), int n);
// �֐��|�C���^�Ɏg���֐�
int dbl(int);
int hlf(int);

int main(int argc, char** argv) {
	funcp(dbl, 8);		// �����Ƃ��āA�֐���n��
	funcp(hlf, 8);		// �����Ƃ��āA�֐���n��
	return 0;
}

// �����Ƃ��ė^�����֐������s���Č��ʂ��\������
void funcp(int (*f)(int), int n) {
	printf("����:%d ����%d\n", n, f(n));
}

// ������{�ɂ��ĕԂ�
int dbl(int n) {
	return n * 2;
}

// �����𔼕��ɂ��ĕԂ�
int hlf(int n) {
	return n / 2;
}
