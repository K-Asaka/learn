#include <stdio.h>

int main(int argc, char** argv) {
	int month;
	printf("Œ(1`12)‚Ì’l‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢:");
	// Œ‚ğ“ü—Í
	scanf("%d", &month);
	switch (month) {
	case 12:
	case 1:
	case 2:
		printf("“~‚Å‚·\n");
		break;
	case 3:
	case 4:
	case 5:
		printf("t‚Å‚·\n");
		break;
	case 6:
	case 7:
	case 8:
		printf("‰Ä‚Å‚·\n");
		break;
	case 9:
	case 10:
	case 11:
		printf("H‚Å‚·\n");
		break;
	default:
		// 1`12ˆÈŠO‚Ì’l‚¾‚Á‚½ê‡
		printf("•s“KØ‚È’l‚Å‚·\n");
		break;
	}
	return 0;
}