#include <stdio.h>

int main(int argc, char** argv) {
	// �|�C���^��NULL�ŏ�����
	int* p = NULL;
	// �A�h���X���w�肵�Ȃ��܂ܒl����
	*p = 1;
	return 0;
}