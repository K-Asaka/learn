#include <stdio.h>
#include <string.h>

// �w���̃f�[�^������\����
struct student{
	int id;			// �w���ԍ�
	char name[256];	// ���O
	int age;		// �N��
};

int main(int argc, char** argv) {
	// �\���̕ϐ��̐錾
	struct student data;
	// �����o�ɒl����
	data.id = 1;						// �w���ԍ�:1
	strcpy(data.name, "�R�c���Y");		// ���O:�R�c���Y
	data.age = 18;						// �N��:18
	// �f�[�^�̓����\��
	printf("�w���ԍ�:%d ���O:%s �N��:%d\n", data.id, data.name, data.age);
	return 0;
}