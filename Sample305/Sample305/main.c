#include <stdio.h>

// while����do�`while���̔�r
int main(int argc, char** argv) {
	int i, num;
	printf("�񐔂����:");
	scanf("%d", &num);		// �L�[�{�[�h���烋�[�v�̉񐔂����
	// while���Ŏ��s
	printf("while�Ŏ��s\n");
	i = 1;
	while (i <= num) {
		printf("*");
		i++;
	}
	printf("\n");
	// do�`while���Ŏ��s
	printf("do�`while�Ŏ��s\n");
	i = 1;
	do {
		printf("*");
		i++;
	} while (i <= num);
	printf("\n");
	return 0;
}