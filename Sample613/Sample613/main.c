#include <stdio.h>

// �f�[�^������\����
typedef struct {
	int a;
	double d;
} num_data;

// ���ނ̒l�ݒ�֐�
void dealData1(num_data data);		// �l�n��
void dealData2(num_data* pData);	// �|�C���^�n��

int main(int argc, char** argv) {
	num_data n1 = { 1, 1.2f }, n2 = { 1, 1.2f };
	printf("n1�̃A�h���X:0x%x n2�̃A�h���X0x%x\n", &n1, &n2);
	dealData1(n1);
	dealData2(&n2);
	printf("n1.a = %d n1.d = %f\n", n1.a, n1.d);
	printf("n2.a = %d n2.d = %f\n", n2.a, n2.d);
	return 0;
}

void dealData1(num_data data) {
	printf("a=%d f=%f\n", data.a, data.d);
	printf("dealData1�ɓn���Ă����f�[�^�̃A�h���X:0x%x\n", &data);
	// �l�̕ύX
	data.a = 2;
	data.d = 2.4;
}

void dealData2(num_data* pData) {
	printf("a=%d f=%f\n", pData->a, pData->d);
	printf("dealData2�ɓn���Ă����f�[�^�̃A�h���X:0x%x\n", pData);
	// �l�̕ύX
	pData->a = 2;
	pData->d = 2.4;
}