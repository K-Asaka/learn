#include <stdio.h>

void show(char**);

int main(int argc, char** argv) {
	// ������̔z��
	char* s[] = { "Taro", "Hanako", "Tom" };
	int i;
	printf("** s�̔z��Ƃ��ĕ\�� **\n");
	for (i = 0; i < 3; i++) {
		printf("%s\n", s[i]);
	}
	// �֐��̈����Ƃ��ĕ�����̔z���n��
	show(s);
	return 0;
}

// �����̕������\������
void show(char** pps) {
	int i;
	printf("** show�֐��Ƃ��ĕ\�� **\n");
	for (i = 0; i < 3; i++) {
		printf("%s\n", pps[i]);
	}
}