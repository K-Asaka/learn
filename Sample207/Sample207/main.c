#include <stdio.h>

int main(int argc, char** argv) {
	int i1, i2, j1, j2;
	double d1, d2, e1, e2;
	// j1,j2�ɒl����
	j1 = 3;
	j2 = 3;
	// d1,d2�ɒl����
	d1 = 1.23;
	d2 = 1.23;
	// i1,i2��d1,d2�̒l����
	i1 = d1;			// ���ʂɑ��
	i2 = (int)d2;		// �L���X�g���đ��
	// e1,e2��j1,j2�̒l����
	e1 = j1;			// ���ʂɑ��
	e2 = (double)j2;	// �L���X�g���đ��
	printf("d1 = %f d2 = %lf\n", d1, d2);
	printf("i1 = %d i2 = %d\n", i1, i2);
	printf("j1 = %d j2 = %d\n", j1, j2);
	printf("e1 = %f e2 = %lf\n", e1, e2);
	return 0;
}