#include <stdio.h>

int main(int argc, char** argv) {
	double bottom, height;		// 底辺と高さ
	printf("三角形の底辺を入力:");
	scanf("%lf", &bottom);
	printf("三角形の高さを入力:");
	scanf("%lf", &height);
	if (bottom == 0.0 || height == 0.0) {
		printf("面積を計算できません。\n");
	}
	else {
		printf("三角形の面積は%lfです。\n", bottom * height / 2);
	}
	return 0;
}