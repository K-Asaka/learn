#include <stdio.h>
#include <string.h>

int main(int argc, char** argv) {
	char s[10];
	int len;
	// ������̃R�s�[
	strcpy(s, "ABC");
	printf("s=%s\n", s);
	// ������̌���
	strcat(s, "DEF");
	printf("s=%s\n", s);
	// ������̒���
	len = strlen(s);
	printf("������̒���:%d\n", len);
	return 0;
}