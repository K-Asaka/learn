#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE	4

void show(int*);
int desc(const void*, const void*);

int main(int argc, char** argv) {
	int a[SIZE], i;
	// �����̏�����
	srand((unsigned)time(NULL));
	// 1����10�܂ł̗����𔭐�������
	for (i = 0; i < SIZE; i++) {
		a[i] = rand() % 10 + 1;
	}
	// �z��̏����l�̕\��
	show(a);
	qsort(a, SIZE, sizeof(int), desc);
	// �\�[�g�̌��ʂ̕\��
	show(a);
	return 0;
}

// �~���̕��בւ��̔���
int desc(const void* a, const void* b) {
	return *(int*)b - *(int*)a;
}

// �z��̓��e�̕\��
void show(int* array) {
	int i;
	for (i = 0; i < SIZE; i++) {
		printf("%d ", array[i]);
	}
	printf("\n");
}
