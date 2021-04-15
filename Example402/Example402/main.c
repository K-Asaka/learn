#include <stdio.h>

// 1から引数として与えられた引数までの間にあるその数の約数の数
int num_divisors(int);
// 1～nまでの素数を表示(数が多い場合には10ごとに改行)
void show_primes(int);

int main(int argc, char** argv) {
	int num;
	printf("自然数を入力:");
	scanf("%d", &num);
	show_primes(num);
	return 0;
}

int num_divisors(int n) {
	int i, count = 0;
	// 1からnまでの間にnの約数がいくつあるかを数える
	for (i = 1; i <= n; i++) {
		if (n % i == 0) {
			count++;
		}
	}
	return count;
}

void show_primes(int n) {
	int i = 2, j = 0;
	// 1以下の数であれば不適切なので関数の処理を終える
	if (n <= 1) {
		printf("不適切な値です\n");
		return;
	}
	printf("1から%dまでの間の素数\n", n);
	// 1～nまでの間の素数を表示する
	while (i <= n) {
		// 約数が1およびiのみの場合num_divisors関数の戻り値は2となる
		if (num_divisors(i) == 2) {
			printf("%d ", i);
			j++;
			// 値を10表示するごとに改行
			if (j == 10) {
				printf("\n");
				j = 0;
			}
		}
		i++;
	}
}