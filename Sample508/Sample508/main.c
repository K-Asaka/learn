#include <stdio.h>
#include <string.h>

int main(int argc, char** argv) {
	char s[] = "���{��̕�����";
	int len;
	len = strlen(s);
	printf("�u%s�v�̒�����%d�ł��B\n", s, len);
	return 0;
}