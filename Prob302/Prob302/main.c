#include <stdio.h>

int main(int argc, char** argv) {
	int a, b, i, tmp;
	printf("���l�����:");
	scanf("%d", &a);
	printf("���l�����:");
	scanf("%d", &b);
	// b���a�̒l�̕����傫����΁Aa��b�̒l�����ւ���
	if (a > b) {
		tmp = a;
		a = b;
		b = tmp;
	}
	// ���������̐�(a)����A�傫�����̐�(b)�܂�1���l�𑝂₷
	for (i = a; i <= b; i++) {
		printf("%d ", i);
	}
	// ���s���ďI��
	printf("\n");
	return 0;
}