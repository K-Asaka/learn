#include <stdio.h>

// •Ï”‚Ì’l“ü‚ê‘Ö‚¦‚ğs‚¤ŠÖ”
void swap(int*, int*);

int main(int argc, char** argv) {
	int a = 1, b = 2;
	printf("a = %d b = %d\n", a, b);
	swap(&a, &b);
	printf("a = %d b = %d\n", a, b);
	return 0;
}

// ’l‚Ì“ü‚ê‘Ö‚¦
void swap(int* num1, int* num2) {
	int temp = *num1;
	*num1 = *num2;
	*num2 = temp;
}
