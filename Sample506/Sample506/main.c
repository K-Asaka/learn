#include <stdio.h>

int main(int argc, char** argv) {
	// �z��ƃ|�C���^�ϐ���p�ӂ���
	double d[3] = { 0.2, 0.4, 0.6 };
	double* p1 = NULL, * p2 = NULL;
	int i;
	p1 = d;		// p1��d�̃A�h���X�����
	p2 = d;		// p2��d�̃A�h���X�����
	for (i = 0; i < 3; i++) {
		printf("%f %f %f\n", *(d + i), p1[i], *p2);
		p2++;		// p2�̃A�h���X���C���N�������g
	}
	return 0;
}