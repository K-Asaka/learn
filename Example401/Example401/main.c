#include <stdio.h>

// 3�̕��ϒl�����߂�֐�avg3�̃v���g�^�C�v�錾
double avg3(double, double, double);

int main(int argc, char** argv) {
	int i;
	double d[3], avg;
	for (i = 0; i < 3; i++) {
		printf("%d�Ԗڂ̐��l�����:", i + 1);
		scanf("%lf", &d[i]);
	}
	avg = avg3(d[0], d[1], d[2]);
	printf("���ϒl:%lf\n", avg);
	return 0;
}

// �֐�avg3�̒�`
double avg3(double d1, double d2, double d3) {
	return (d1 + d2 + d3) / 3.0;
}