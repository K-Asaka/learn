#include <stdio.h>
#include <string.h>

int main(int argc, char** argv) {
	char s1[256], s2[256], s[512];
	printf("1�ڂ̕�����:");
	scanf("%s", s1);
	printf("2�ڂ̕�����:");
	scanf("%s", s2);
	// s1��s�ɃR�s�[
	strcpy(s, s1);
	// s2��s�ɒǉ�
	strcat(s, s2);
	// ���ʂ�\��
	printf("��������������:%s\n", s);
	return 0;
}