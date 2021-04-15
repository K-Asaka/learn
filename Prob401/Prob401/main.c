#include <stdio.h>

// add3関数のプロトタイプ宣言
int add3(int, int, int);

int main(int argc, char** argv) {
	int a, b, c, sum;
	// a,b,cにキーボードから値を入力
	printf("a=");
	scanf("%d", &a);
	printf("b=");
	scanf("%d", &b);
	printf("c=");
	scanf("%d", &c);
	// add3関数で合計を計算
	sum = add3(a, b, c);
	printf("a + b + c = %d\n", sum);
}

// add3関数の定義
int add3(int a, int b, int c) {
	return a + b + c;
}