#include <stdio.h>
#include <string.h>

int main(int argc, char** argv) {
	char s[10];
	int len;
	// •¶š—ñ‚ÌƒRƒs[
	strcpy(s, "ABC");
	printf("s=%s\n", s);
	// •¶š—ñ‚ÌŒ‹‡
	strcat(s, "DEF");
	printf("s=%s\n", s);
	// •¶š—ñ‚Ì’·‚³
	len = strlen(s);
	printf("•¶š—ñ‚Ì’·‚³:%d\n", len);
	return 0;
}