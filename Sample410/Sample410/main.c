#include <stdio.h>
#include <math.h>

#define PI 3.14

int main(int argc, char** argv) {
	int angle;
	double rad;
	printf("�p�x����͂��Ă�������(0�`360):");
	scanf("%d", &angle);
	// �p�x�����W�A���ɕϊ�
	rad = PI * (double)angle / 180.0;
	// �O�p�֐��ł̌v�Z
	printf("sin(%d)=%f\n", angle, sin(rad));
	printf("cos(%d)=%f\n", angle, cos(rad));
	printf("tan(%d)=%f\n", angle, tan(rad));
	return 0;
}