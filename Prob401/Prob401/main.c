#include <stdio.h>

// add3�֐��̃v���g�^�C�v�錾
int add3(int, int, int);

int main(int argc, char** argv) {
	int a, b, c, sum;
	// a,b,c�ɃL�[�{�[�h����l�����
	printf("a=");
	scanf("%d", &a);
	printf("b=");
	scanf("%d", &b);
	printf("c=");
	scanf("%d", &c);
	// add3�֐��ō��v���v�Z
	sum = add3(a, b, c);
	printf("a + b + c = %d\n", sum);
}

// add3�֐��̒�`
int add3(int a, int b, int c) {
	return a + b + c;
}