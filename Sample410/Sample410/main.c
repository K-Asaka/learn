#include <stdio.h>
#include <math.h>

#define PI 3.14

int main(int argc, char** argv) {
	int angle;
	double rad;
	printf("Šp“x‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢(0`360):");
	scanf("%d", &angle);
	// Šp“x‚ğƒ‰ƒWƒAƒ“‚É•ÏŠ·
	rad = PI * (double)angle / 180.0;
	// OŠpŠÖ”‚Å‚ÌŒvZ
	printf("sin(%d)=%f\n", angle, sin(rad));
	printf("cos(%d)=%f\n", angle, cos(rad));
	printf("tan(%d)=%f\n", angle, tan(rad));
	return 0;
}