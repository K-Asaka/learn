#include <stdio.h>

int max_n(int, int);
int min_n(int, int);

int main(int argc, char** argv) {
	int (*cmp)(int, int) = max_n;		// cmp�̐錾��max_n�̑��
	int a = 1, b = 2;
	printf("%d��%d�̂����A�ő�̂��̂́A%d\n", a, b, cmp(a, b));
	cmp = min_n;		// cmp��min_n����
	printf("%d��%d�̂����A�ő�̂��̂́A%d\n", a, b, cmp(a, b));
	return 0;
}

// �ő�l��Ԃ��֐�
int max_n(int m, int n) {
	if (m > n) {
		return m;
	}
	return n;
}

// �ŏ��l��Ԃ��֐�
int min_n(int m, int n) {
	if (m < n) {
		return m;
	}
	return n;
}
