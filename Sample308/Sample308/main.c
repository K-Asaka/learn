#include <stdio.h>

int main(int argc, char** argv) {
	int i;
	for (i = 0; i < 5; i++) {
		// i��3�̂Ƃ��A���[�v���X�L�b�v
		if (i == 3) {
			continue;
		}
		printf("i=%d\n", i);
	}
	return 0;
}