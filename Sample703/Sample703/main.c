#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	// �t�@�C���|�C���^(�ǂݍ��ݗp)
	FILE* file;
	// �ǂݍ��ޕ����̃R�[�h
	int c;
	// �t�@�C����ǂݍ��ݗp�ɃI�[�v��(�J��)
	file = fopen("i:\\C\\Sample701\\Sample701\\sample.txt", "r");
	if (file == NULL) {
		// �I�[�v���Ɏ��s�����ꍇ�ُ�I��
		printf("�t�@�C�����J���܂���B\n");
		return 1;
	}
	// �t�@�C���̃f�[�^�ǂݍ���
	while ((c = fgetc(file)) != EOF) {
		printf("%c", (char)c);
	}
	// �t�@�C�����N���[�Y����
	fclose(file);
	return 0;
}