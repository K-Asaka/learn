#include <stdio.h>

// ������̒��������߂�
int my_strlen(char*);

int main(int argc, char** argv) {
	char str[256];
	int length;
	printf("����������:");
	scanf("%s", str);
	length = my_strlen(str);
	printf("������̒���:%d\n", length);
	return 0;
}

int my_strlen(char* s) {
	int length = 0;
	// ������̒��������߂�
	while (*s != '\0') {
		// '\0'�ɂ��ǂ蒅���܂ŃJ�E���g�𑱂���
		length++;
		s++;
	}
	return length;
}