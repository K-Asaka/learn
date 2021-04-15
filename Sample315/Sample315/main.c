#include <stdio.h>

// •¶š—ñ‚Ìˆµ‚¢
int main(int argc, char** argv) {
	char s1[4] = { 'a', 'b', 'c', '\0' };	// •¶š—ñ"abc"
	char s2[] = "HelloWorld";				// •¶š—ñ"HelloWorld"
	char s3[10];							// Å‘å10•¶š‚Ü‚Å“ü‚é•¶š—ñ
	// •¶š—ñ‚Ì“ü—Í
	printf("•¶š—ñ‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B:");
	scanf("%s", s3);		// •¶š—ñ‚Ì“ü—Í
	printf("s1 = %s\n", s1);
	printf("s2 = %s\n", s2);
	printf("s3 = %s\n", s3);
	return 0;
}