#include <stdio.h>

// ������̈���
int main(int argc, char** argv) {
	char s1[4] = { 'a', 'b', 'c', '\0' };	// ������"abc"
	char s2[] = "HelloWorld";				// ������"HelloWorld"
	char s3[10];							// �ő�10�����܂œ��镶����
	// ������̓���
	printf("���������͂��Ă��������B:");
	scanf("%s", s3);		// ������̓���
	printf("s1 = %s\n", s1);
	printf("s2 = %s\n", s2);
	printf("s3 = %s\n", s3);
	return 0;
}