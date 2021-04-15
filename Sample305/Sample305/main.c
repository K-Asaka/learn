#include <stdio.h>

// while文とdo～while文の比較
int main(int argc, char** argv) {
	int i, num;
	printf("回数を入力:");
	scanf("%d", &num);		// キーボードからループの回数を入力
	// while文で実行
	printf("whileで実行\n");
	i = 1;
	while (i <= num) {
		printf("*");
		i++;
	}
	printf("\n");
	// do～while文で実行
	printf("do～whileで実行\n");
	i = 1;
	do {
		printf("*");
		i++;
	} while (i <= num);
	printf("\n");
	return 0;
}