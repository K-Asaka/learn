#include <stdio.h>
#include <stdlib.h>

#define SIZE	256

int main(int argc, char** argv) {
	// �t�@�C���|�C���^(�ǂݍ��ݗp)
	FILE* file;
	// �ǂݍ��ލs
	char line[SIZE];
	// ������(�󕶎���)
	line[0] = '\0';
	// �t�@�C����ǂݍ��ݗp�ɃI�[�v��(�J��)
	file = fopen("I:\\C\\Sample701\\Sample701\\sample.txt", "r");
	if (file == NULL) {
		// ���s�����ꍇ�G���[���b�Z�[�W���o���Ĉُ�I��
		printf("�t�@�C�����J���܂���B\n");
		return 1;
	}
	// �t�@�C���̃f�[�^��ǂݍ���
	while (fgets(line, SIZE, file) != NULL) {
		printf("%s", line);
	}
	// �t�@�C�����N���[�Y(����)
	fclose(file);
	return 0;
}