#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// �z��̒����������\������
void show_even(int*);

int main(int argc, char** argv) {
	int a[10], i;
	// �����̏�����
	srand((unsigned)time(NULL));
	printf("����:");
	// �z��ɒl�������Ȃ���l��\������
	for (i = 0; i < 10; i++) {
		a[i] = rand() % 10 + 1;
		printf("%d ", a[i]);
	}
	// ���s
	printf("\n");
	// ������\��
	show_even(a);
	return 0;
}

void show_even(int* a) {
	int i;
	printf("����:");
	for (i = 0; i < 10; i++) {
		// �z��̒l�������ł���΁A���̒l��\������
		if (a[i] % 2 == 0) {
			printf("%d ", a[i]);
		}
	}
	// ���s
	printf("\n");
}