#include <stdio.h>
#include <math.h>

int main(int argc, char** argv) {
	int n = -2;
	double d1 = -2.5, d2 = 4.0;
	printf("%d�̐�Βl��%d\n", n, abs(n));
	printf("%f�̐�Βl��%f\n", d1, fabs(d1));
	printf("%f��2���%f�ł��B\n", d2, pow(d2, 2));
	printf("%f�̕�������%f�ł��B\n", d2, sqrt(d2));
	return 0;
}