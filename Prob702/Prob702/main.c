#include <stdio.h>
#include <stdlib.h>

#define SIZE	5

void show(char**);

int main(int argc, char** argv) {
	int i, j;
	char* a[] = { "banana", "apple", "orange", "lemon", "pineapple" };
	show(a);
	// �o�u���\�[�g(����)
	for (i = 0; i < SIZE; i++) {
		for (j = i + 1; j < SIZE; j++) {
			// �������t�Ȃ����ւ���
			if (strcmp(a[i], a[j]) > 0) {
				// a[i]��a[j]�̓��ꂩ��
				char* tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
	}
	// ���ʂ̕\��
	show(a);
	return 0;
}

// �z��̓��e�̕\��
void show(char** array) {
	int i;
	for (i = 0; i < SIZE; i++) {
		printf("%s ", array[i]);
	}
	printf("\n");
}