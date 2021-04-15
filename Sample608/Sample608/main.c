#include <stdio.h>

int g = 10;		// ŠO•”•Ï”‚ÌéŒ¾

void showExterns();

int main(int argc, char** argv) {
	// ’l‚Ì•\¦
	printf("mainŠÖ”:g=%d\n", g);
	showExterns();
	return 0;
}

void showExterns() {
	printf("showExternsŠÖ”:g=%d\n", g);
}