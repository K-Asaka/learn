#include <stdio.h>
#include <string.h>

// �w���̃f�[�^������\����
typedef struct {
	int id;					// �w���ԍ�
	char name[256];			// ���O
	int age;				// �N��
} student_data;

// �\���̃f�[�^��\������֐�
void setData(student_data*, int, char*, int);
void showData(student_data*);

int main(int argc, char** argv) {
	student_data data[4];
	int i;
	int id[] = { 1, 2, 3, 4, };
	char name[][256] = { "�R�c���Y", "�����ǎq", "���c��", "���c�D�q" };
	int age[] = { 18, 19, 18, 18 };
	// �f�[�^�̐ݒ�
	for (i = 0; i < 4; i++) {
		setData(&data[i], id[i], name[i], age[i]);
	}
	// �f�[�^�̓����\��
	for (i = 0; i < 4; i++) {
		showData(&data[i]);
	}
	return 0;
}

// �f�[�^�̃Z�b�g
void setData(student_data* pData, int id, char* name, int age) {
	pData->id = id;				// id�̃R�s�[
	strcpy(pData->name, name);	// name�̃R�s�[
	pData->age = age;			// age�̃R�s�[
}

// �f�[�^�̕\��
void showData(student_data* pData) {
	printf("�w���ԍ�:%d ���O:%s �N��:%d\n", pData->id, pData->name, pData->age);
}
