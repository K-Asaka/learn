#include <stdio.h>
#include <string.h>

int main(int argc, char** argv) {
	char s1[256], s2[256], s[512];
	char* cp1 = NULL, * cp2 = NULL;
	printf("1�ڂ̕�����:");
	scanf("%s", s1);
	printf("2�ڂ̕�����:");
	scanf("%s", s2);
	// s1��s�ɃR�s�[
	cp1 = s1;
	cp2 = s;
	while (*cp1 != '\0') {
		*cp2 = *cp1;
		cp1++;
		cp2++;
	}
	// s2��s�ɒǉ�
	cp1 = s2;
	while (*cp1 != '\0') {
		*cp2 = *cp1;
		cp1++;
		cp2++;
	}
	// �Ō��'\0'��ǉ�
	*cp2 = '\0';
	// ���ʂ�\��
	printf("��������������:%s\n", s);
	return 0;
}