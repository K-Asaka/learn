#include <stdio.h>

int main(int argc, char** argv) {
	int a[] = { 3, 2, 9, 8, 5, 6, 5, 4, 1 };
	int i, sum = 0, max_num, min_num;
	double avg;
	// ���̍ő�l�����ꂼ��a[0]�ɐݒ肷��
	max_num = a[0];
	min_num = a[0];
	// ������\�����Ȃ��獇�v�l�A�ő�l�A�ŏ��l�����߂�
	for (i = 0; i < 9; i++) {
		// �l��\������
		printf("%d ", a[i]);
		// �b��̍ő�l����a[i]�̒l���傫����΍X�V����
		if (max_num < a[i]) {
			max_num = a[i];
		}
		// �b��̍ŏ��l����a[i]�̒l����������΍X�V����
		if (min_num > a[i]) {
			min_num = a[i];
		}
		// ���v�l���v�Z����
		sum += a[i];
	}
	printf("\n");
	// ���v�l�����ƂɁA���ϒl���v�Z����
	avg = sum / 9.0;
	// ���v�l�A���ϒl�A�ő�l�A�ŏ��l��\������
	printf("���v�l:%d ���ϒl:%lf �ő�l:%d �ŏ��l:%d\n", sum, avg, max_num, min_num);
	return 0;
}