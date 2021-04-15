#include <stdio.h>

// 計算の答え(グローバル変数)
int ans = 0;

void add(int, int);
void sub(int, int);
void showAnswer();

int main(int argc, char** argv) {
	int a = 2, b = 3;
	printf("%d + %d = ", a, b);
	add(a, b);
	showAnswer();
	printf("%d - %d = ", a, b);
	sub(a, b);
	showAnswer();
	return 0;
}

void add(int a, int b) {
	ans = a + b;
}

void sub(int a, int b) {
	ans = a - b;
}

void showAnswer() {
	printf("%d\n", ans);
}
