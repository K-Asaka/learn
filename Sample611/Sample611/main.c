#include <stdio.h>
#include <string.h>

// �w���̃f�[�^������\����
struct student {
	int id;				// �w���ԍ�
	char name[256];		// ���O
	int age;			// �N��
};

// �\���̖̂��O��typedef�Œ�`
typedef struct student student_data;

int main(int argc, char** argv) {
	int i;
	student_data data[] = {
		{ 1, "�R�c���Y", 18 },
		{ 2, "�����ǎq", 19 },
		{ 3, "���c��", 18 },
		{ 4, "���c�D�q", 18 }
	};
	// �f�[�^�̓����\��
	for (i = 0; i < 4; i++) {
		printf("�w���ԍ�:%d ���O:%s �N��:%d\n", data[i].id, data[i].name, data[i].age);
	}
	return 0;
}