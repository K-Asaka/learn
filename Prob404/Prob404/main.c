#include <stdio.h>
#include "triangle.h"

int main(int argc, char** argv) {
	int num;
	printf("³‚Ì®”‚ğ“ü—Í:");
	scanf("%d", &num);
	if (num > 0) {
		showTriangle(num);
	}
	else {
		printf("³‚Ì”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B\n");
	}
	return 0;
}