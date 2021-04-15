#include <stdio.h>

// •¶š—ñ‚Ì’·‚³‚ğ‹‚ß‚é
int my_strlen(char*);

int main(int argc, char** argv) {
	char str[256];
	int length;
	printf("•¶š—ñ‚ğ“ü—Í:");
	scanf("%s", str);
	length = my_strlen(str);
	printf("•¶š—ñ‚Ì’·‚³:%d\n", length);
	return 0;
}

int my_strlen(char* s) {
	int length = 0;
	// •¶š—ñ‚Ì’·‚³‚ğ‹‚ß‚é
	while (*s != '\0') {
		// '\0'‚É‚½‚Ç‚è’…‚­‚Ü‚ÅƒJƒEƒ“ƒg‚ğ‘±‚¯‚é
		length++;
		s++;
	}
	return length;
}