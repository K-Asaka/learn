#include <stdio.h>

// ������̒��Ɏw�肵���P�ꂪ�����������Ă��邩���J�E���g����
void count(char*, char);

int main(int argc, char** argv) {
	char s[256], c;
	printf("�p�P������:");
	scanf("%s", s);
	// �P��̒��Ɋ܂܂��a�`z�܂ł̕�������J�E���g����
	for (c = 'a'; c <= 'z'; c++) {
		count(s, c);
	}
	// �P��̒��Ɋ܂܂��A�`Z�܂ł̕�������J�E���g����
	for (c = 'A'; c <= 'Z'; c++) {
		count(s, c);
	}
	return 0;
}

void count(char* s, char c) {
	// �������T������|�C���^
	char* cp = s;
	// �w�肵������c���J�E���g����ϐ�
	int count = 0;
	while (*cp != '\0') {
		if (*cp == c) {
			count++;
		}
		cp++;
	}
	// 1�����ȏ�w��̒P�ꂪ���������琔��\������
	if (count > 0) {
		printf("%c:%d����\n", c, count);
	}
}