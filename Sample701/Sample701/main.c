#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	// �t�@�C���|�C���^(�o�͗p)
	FILE* file;
	// �t�@�C�����������ݗp�ɃI�[�v��(�J��)
	file = fopen("sample.txt", "w");
	if (file == NULL) {
		// �I�[�v���Ɏ��s�����ꍇ�G���[���b�Z�[�W���o��
		printf("�t�@�C�����J���܂���B\n");
		// �ُ�I��
		return 1;
	}
	// �t�@�C���Ƀf�[�^����������
	fprintf(file, "Hello World.\n");
	fprintf(file, "ABCDEF\n");
	// �t�@�C�����N���[�Y(����)
	fclose(file);
	return 0;
}