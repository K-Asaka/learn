#include <stdio.h>

int main(int argc, char** argv) {
	double bottom, height;		// ��ӂƍ���
	printf("�O�p�`�̒�ӂ����:");
	scanf("%lf", &bottom);
	printf("�O�p�`�̍��������:");
	scanf("%lf", &height);
	if (bottom == 0.0 || height == 0.0) {
		printf("�ʐς��v�Z�ł��܂���B\n");
	}
	else {
		printf("�O�p�`�̖ʐς�%lf�ł��B\n", bottom * height / 2);
	}
	return 0;
}