#include <stdio.h>

int main(int argc, char** argv) {
	int i, n, sum = 0;
	for (i = 1; i < argc; i++) {
		// �R�}���h���C�������̒l�𐮐��ɕϊ�
		n = atoi(argv[i]);
		// �l��\��
		printf("%d ", n);
		// ���v���v�Z
		sum += n;
	}
	printf("\n���v:%d\n", sum);
	return 0;
}