#include <stdio.h>

int main(int argc, char** argv) {
	// �T�C�Y3�̔z��ϐ��̐錾
	double d[3];
	double sum, avg;		// ���v�l�A���ϒl������ϐ�
	int i;
	// �l����
	d[0] = 1.2;
	d[1] = 3.7;
	d[2] = 4.1;
	sum = 0.0;
	for (i = 0; i < 3; i++) {
		printf("%f ", d[i]);
		sum += d[i];
	}
	printf("\n");
	avg = sum / 3.0;		// ���ϒl�̌v�Z
	printf("���v�l:%f\n", sum);
	printf("���ϒl:%f\n", avg);
	return 0;
}