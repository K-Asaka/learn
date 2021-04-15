#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char** argv) {
	int a, b;
	// —”‚Ì‰Šú‰»
	srand((unsigned)time(NULL));
	// 1‚©‚ç10‚Ü‚Å‚Ì—”‚ğ”­¶‚³‚¹‚é
	a = rand() % 10 + 1;
	b = rand() % 10 + 1;
	// ŒvZŒ‹‰Ê‚ğo—Í
	printf("%d + %d = %d\n", a, b, a + b);
	return 0;
}