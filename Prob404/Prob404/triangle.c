#include "triangle.h"

// nŒÂ‚Ìš‚ğ•\¦
void showStars(int n) {
	int i;
	for (i = 0; i < n; i++) {
		printf("š");
	}
	printf("\n");
}

// š‚ÅOŠpŒ`‚ğì‚é
void showTriangle(int n) {
	int i;
	for (i = 1; i <= n; i++) {
		showStars(i);
	}
}