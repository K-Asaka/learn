#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char** argv) {
	int a, b, ans, num;
	// �����̏�����
	srand((unsigned)time(NULL));
	// 1����10�܂ł̗����𔭐�������
	a = rand() % 10 + 1;
	b = rand() % 10 + 1;
	// ���̉񓚂��v�Z����
	ans = a + b;
	// �v�Z���ʂ��o��
	printf("���:%d + %d\n", a, b);
	// �������o��܂œ��͂��J��Ԃ��������[�v
	while (1) {
		// �L�[�{�[�h���瓚������͂�����
		printf("���������:");
		scanf("%d", &num);
		if (num == ans) {
			// �����Ȃ�break�Ń��[�v�𔲂���
			printf("�����ł�\n");
			break;
		}
		// �ԈႢ�Ȃ烋�[�v���甲���Ȃ�
		printf("�ԈႢ�ł�\n");
	}
	return 0;
}