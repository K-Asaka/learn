#include <stdio.h>

void uppercase_str(char*, char*);

int main(int argc, char** argv) {
	char str1[256], str2[256];
	printf("�p�P������:");
	scanf("%s", str1);
	uppercase_str(str1, str2);
	printf("�ϊ���̕�����:%s\n", str2);
	return 0;
}

void uppercase_str(char* s1, char* s2) {
	while (*s1 != '\0') {
		// �P�ꂪ���������ǂ����𔻒肷��
		if (*s1 >= 'a' && *s1 <= 'z') {
			// ��������啶���ɕς��ăR�s�[
			*s2 = *s1 - 'a' + 'A';
		}
		else {
			// ����ȊO�͂��̂܂܃R�s�[
			*s2 = *s1;
		}
		// ���̕����ֈڍs
		s1++;
		s2++;
	}
	// �R�s�[����������̍Ō�Ɂu\0�v��}��
	*s2 = '\0';
}