#include <stdio.h>
#include "triangle.h"

int main(int argc, char** argv) {
	int num;
	printf("���̐��������:");
	scanf("%d", &num);
	if (num > 0) {
		showTriangle(num);
	}
	else {
		printf("���̐�����͂��Ă��������B\n");
	}
	return 0;
}