#include <stdio.h>

// 1��������Ƃ��ė^����ꂽ�����܂ł̊Ԃɂ��邻�̐��̖񐔂̐�
int num_divisors(int);
// 1�`n�܂ł̑f����\��(���������ꍇ�ɂ�10���Ƃɉ��s)
void show_primes(int);

int main(int argc, char** argv) {
	int num;
	printf("���R�������:");
	scanf("%d", &num);
	show_primes(num);
	return 0;
}

int num_divisors(int n) {
	int i, count = 0;
	// 1����n�܂ł̊Ԃ�n�̖񐔂��������邩�𐔂���
	for (i = 1; i <= n; i++) {
		if (n % i == 0) {
			count++;
		}
	}
	return count;
}

void show_primes(int n) {
	int i = 2, j = 0;
	// 1�ȉ��̐��ł���Εs�K�؂Ȃ̂Ŋ֐��̏������I����
	if (n <= 1) {
		printf("�s�K�؂Ȓl�ł�\n");
		return;
	}
	printf("1����%d�܂ł̊Ԃ̑f��\n", n);
	// 1�`n�܂ł̊Ԃ̑f����\������
	while (i <= n) {
		// �񐔂�1�����i�݂̂̏ꍇnum_divisors�֐��̖߂�l��2�ƂȂ�
		if (num_divisors(i) == 2) {
			printf("%d ", i);
			j++;
			// �l��10�\�����邲�Ƃɉ��s
			if (j == 10) {
				printf("\n");
				j = 0;
			}
		}
		i++;
	}
}