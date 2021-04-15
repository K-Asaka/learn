#include <stdio.h>

int main(int argc, char** argv) {
	int month;
	printf("月(1～12)の値を入力してください:");
	// 月を入力
	scanf("%d", &month);
	if (month == 12 || month == 1 || month == 2) {
		// 12,1,2だった場合
		printf("冬です\n");
	}
	else if (month == 3 || month == 4 || month == 5) {
		// 3,4,5だった場合
		printf("春です\n");
	}
	else if (month == 6 || month == 7 || month == 8) {
		// 6,7,8だった場合
		printf("夏です\n");
	}
	else if (month == 9 || month == 10 || month == 11) {
		// 9,10,11だった場合
		printf("秋です\n");
	}
	else {
		// 1～12以外の値だった場合
		printf("不適切な値です\n");
	}
	return 0;
}