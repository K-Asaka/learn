#include "triangle.h"

// n�́���\��
void showStars(int n) {
	int i;
	for (i = 0; i < n; i++) {
		printf("��");
	}
	printf("\n");
}

// ���ŎO�p�`�����
void showTriangle(int n) {
	int i;
	for (i = 1; i <= n; i++) {
		showStars(i);
	}
}