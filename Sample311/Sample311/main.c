#include <stdio.h>

int main(int argc, char** argv) {
	// �z��ϐ��̏�����
	double d[] = { 1.2, 3.7, 4.1 };
	double sum, avg;		// ���v�l�A���ϒl������ϐ�
	int i;
	sum = 0.0;
	for (i = 0; i < 3; i++) {
		printf("%f ", d[i]);
		sum += d[1];
	}
	printf("\n");
	avg = sum / 3.0;		// ���ϒl�̌v�Z
	printf("���v�l:%f\n", sum);
	printf("���ϒl:%f\n", avg);
	return 0;
}