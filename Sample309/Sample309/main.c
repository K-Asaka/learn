#include <stdio.h>

int main(int argc, char** argv) {
	double one, two, three;				// �ϐ��̐錾
	double sum, avg;					// ���v�l�A���ϒl������ϐ�
	one = 1.2, two = 3.7, three = 4.1;	// �ϐ��̑��
	printf("%f %f %f\n", one, two, three);
	sum = one + two + three;			// ���v�l�̌v�Z
	avg = sum / 3.0;					// ���ϒl�̌v�Z
	printf("���v�l:%f\n", sum);
	printf("���ϒl:%f\n", avg);
	return 0;
}