#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	FILE* file;
	int i, size;
	// �ǂݍ��ރf�[�^
	char* rdata;
	// �o�C�i���f�[�^�̓ǂݍ���
	file = fopen("I:\\C\\Sample704\\Sample704\\test.bin", "rb");
	if (file == NULL) {
		printf("�t�@�C���I�[�v���Ɏ��s���܂����B\n");
		return 0;
	}
	// �t�@�C���̍Ō�܂ŃV�[�N
	fseek(file, 0, SEEK_END);
	// �t�@�C���̑傫�����擾
	size = ftell(file);
	// �������̃T�C�Y�����A�z��𓮓I�ɐ���
	rdata = (char*)malloc(sizeof(char) * size);
	// �t�@�C���̍ŏ��Ƀ|�C���^��߂�
	fseek(file, 0, SEEK_SET);
	fread(rdata, sizeof(char), size, file);
	// �t�@�C�����N���[�Y(����)
	fclose(file);
	// ���ʂ�\��
	for (i = 0; i < size; i++) {
		printf("%x ", rdata[i]);
	}
	printf("\n");
	// ���������
	free(rdata);
	return 0;
}