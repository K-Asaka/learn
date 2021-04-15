#include <stdio.h>

int main(int argc, char** argv) {
	int num1, num2;
	// 2‚Â‚Ì”‚ğ“ü—Í
	printf("num1=");
	scanf("%d", &num1);
	printf("num2=");
	scanf("%d", &num2);
	// ‚Ç‚¿‚ç‚©‚ª³‚Ì”‚©‚Ç‚¤‚©‚ğ”»’è
	if (num1 > 0 || num2 > 0) {
		printf("num1,num2‚Ì‚Ç‚¿‚ç‚©‚ª³‚Ì”‚Å‚·B\n");
	}
	else {
		printf("num1,num2‚Æ‚à‚É³‚Ì”‚Å‚Í‚ ‚è‚Ü‚¹‚ñB\n");
	}
	return 0;
}