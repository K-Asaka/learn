#include <stdio.h>

int main(int argc, char** argv) {
	int length, i;
	int* array = NULL;
	printf("�z��̒���:");
	scanf("%d", &length);
	// �z��̒��������̒l���ǂ������`�F�b�N
	if (length <= 0) {
		printf("�z��̒�����1�ȏ�ɂ��Ă��������B\n");
		return 0;
	}
	// �������������̔z��𐶐�
	array = (int*)malloc(sizeof(int) * length);
	if (array == 0) {
		// �������̐����Ɏ��s�����ꍇ�ɂ́A�I��
		printf("�������̐����Ɏ��s���܂����B\n");
		return 0;
	}
	// ��������
	for (i = 0; i < length; i++) {
		array[i] = rand() % 10 + 1;
	}
	// �����̒l��\��
	printf("���������z��:");
	// �z��̒l��\��
	for (i = 0; i < length; i++) {
		printf("%d ", array[i]);
	}
	printf("\n");
	// �������̉��
	free(array);
	return 0;
}