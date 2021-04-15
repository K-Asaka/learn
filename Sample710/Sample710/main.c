#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE	5

void show(char**);
int dict(const void*, const void*);

int main(int argc, char** argv) {
	// ���בւ��镶����
	char* a[] = { "banana", "apple", "orange", "lemon", "pineapple" };
	// �z��̏����l�̕\��
	show(a);
	qsort(a, SIZE, sizeof(int), dict);
	// �\�[�g�̌��ʂ̕\��
	show(a);
	return 0;
}

// �������̕��בւ��̔���
int dict(const void* a, const void* b) {
	return strcmp(*(const char**)a, *(const char**)b);
}

// �z��̓��e�̕\��
void show(char** array) {
	int i;
	for (i = 0; i < SIZE; i++) {
		printf("%s ", array[i]);
	}
	printf("\n");
}
