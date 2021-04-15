#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE	4

void show(int*);
void swap(int*, int*);

int main(int argc, char** argv) {
	int a[SIZE], i, j;
	// �����̏�����
	srand((unsigned)time(NULL));
	// 1����10�܂ł̗����𔭐�������
	for (i = 0; i < SIZE; i++) {
		a[i] = rand() % 10 + 1;
	}
	// �z��̕\��
	show(a);
	// �o�u���\�[�g(�~��)
	for (i = 0; i < SIZE; i++) {
		for (j = 0; j < SIZE - 1; j++) {
			// �������t�Ȃ����ւ���
			if (a[j] < a[j + 1]) {
				// a[j]��a[j + 1]�̓���ւ�
				swap(&a[j], &a[j + 1]);
			}
			// �r���o�߂̕\��
			show(a);
		}
	}
	return 0;
}

// �z��̓��e�̕\��
void show(int* array) {
	int i;
	for (i = 0; i < SIZE; i++) {
		printf("%d ", array[i]);
	}
	printf("\n");
}

// �l�̌���
void swap(int* num1, int* num2) {
	int temp = *num1;
	*num1 = *num2;
	*num2 = temp;
}
