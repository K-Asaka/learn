#include <stdio.h>

int main(int argc, char** argv) {
	// �z��̒�`
	int a[] = { 2, -4, 9, 5, 10, 7, -2 };
	int i;
	// �z��̐��������ׂĕ\��
	for (i = 0; i < 7; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");

	// �����̐��������ׂĕ\��
	for (i = 0; i < 7; i++) {
		// a[i]��2�Ŋ��������܂肪0�ł���΋����Ɣ��f
		if (a[i] % 2 == 0) {
			printf("%d ", a[i]);
		}
	}
	printf("\n");
	// ���̐��������ׂĕ\��
	for (i = 0; i < 7; i++) {
		if (a[i] > 0) {
			printf("%d ", a[i]);
		}
	}
	printf("\n");
	return 0;
}