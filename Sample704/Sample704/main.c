#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	FILE* file;
	int i;
	// �������ރf�[�^
	char wdata[] = { 0x10, 0x1a, 0x1e, 0x1f };
	char rdata[4];
	// �o�C�i���f�[�^�̏�������
	file = fopen("I:\\C\\Sample704\\Sample704\\test.bin", "wb");
	if (file == NULL) {
		printf("�t�@�C���I�[�v���Ɏ��s���܂����B\n");
		return 1;
	}
	fwrite(wdata, sizeof(char), sizeof(wdata), file);
	fclose(file);				// �t�@�C�����N���[�Y(����)
	// �o�C�i���f�[�^�̓ǂݍ���
	file = fopen("I:\\C\\Sample704\\Sample704\\test.bin", "rb");
	if (file == NULL) {
		printf("�t�@�C���I�[�v���Ɏ��s���܂����B\n");
		return 1;
	}
	fread(rdata, sizeof(char), sizeof(rdata), file);
	fclose(file);
	// ���ʂ�\��
	for (i = 0; i < sizeof(rdata); i++) {
		printf("%x ", rdata[i]);
	}
	printf("\n");
	return 0;
}