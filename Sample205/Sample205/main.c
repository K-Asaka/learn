#include <stdio.h>

int main(int argc, char** argv) {
	// �g�p����ϐ��̒�`
	int a;					// �ϐ��̐錾
	int b = 3;				// �錾�Ƒ���𓯎��ɍs��
	int add, sub;			// �����̕ϐ��𓯎��ɐ錾
	double avg;				// int�ȊO�̕ϐ���錾
	a = 6;					// ���
	add = a + b;			// a,b�̘a�����߂�
	sub = a - b;			// a,b�̍������߂�
	avg = (a + b) / 2.0;	// a,b�̕��ϒl�����߂�
	printf("%d + %d = %d\n", a, b, add);
	printf("%d - %d = %d\n", a, b, sub);
	printf("%d��%d�̕��ϒl:%lf\n", a, b, avg);
	return 0;
}