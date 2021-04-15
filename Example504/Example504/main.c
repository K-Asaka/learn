#include <stdio.h>
#include <string.h>

int main(int argc, char** argv) {
	char str1[256], str2[256];
	int len1, len2;
	printf("•¶Žš—ñ‚ð“ü—Í:");
	scanf("%s", str1);
	printf("•¶Žš—ñ‚ð“ü—Í:");
	scanf("%s", str2);
	len1 = strlen(str1);
	len2 = strlen(str2);
	if (len1 > len2) {
		printf("’·‚¢•¶Žš—ñ:%s\n", str1);
	}
	else if (len1 < len2) {
		printf("’·‚¢•¶Žš—ñ:%s\n", str2);
	}
	else {
		printf("“¯‚¶’·‚³‚Å‚·B\n");
	}
	return 0;
}