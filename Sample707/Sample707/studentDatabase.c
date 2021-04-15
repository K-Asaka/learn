#include "studentDatabase.h"
#include <string.h>

#define MESSAGE_LENGTH	256

// �f�[�^�x�[�X�ɓo�^����Ă���w���̐�
int num_of_students = 0;
// �w���̃f�[�^�x�[�X
static student student_database[MAX_STUDENT];
// �G���[���b�Z�[�W
int Error = MESSAGE_OK;

// �f�[�^�x�[�X�̏�����
void initDatabase() {
	int i;
	for (i = 0; i < MAX_STUDENT; i++) {
		student_database[i].id = -1;
		strcpy(student_database[i].name, "");
	}
	Error = MESSAGE_OK;		// �G���[���b�Z�[�W�̃N���A
	num_of_students = 0;	// �o�^���ꂽ�w���̐���0�ɏ�����
}

// �f�[�^�x�[�X�ւ̃f�[�^�̓o�^(�w���ԍ��A���O)
int add(int id, char* name) {
	// ���łɓo�^����Ă���id�ł���΁A�o�^���Ȃ�
	if (get(id) == NULL && num_of_students < MAX_STUDENT) {
		student_database[num_of_students].id = id;
		strcpy(student_database[num_of_students].name, name);
		num_of_students++;
		Error = MESSAGE_OK;
		// �o�ł�����A1��Ԃ�
		return 1;
	}
	Error = MESSAGE_ERROR;
	// �o�^�ł��Ȃ���΁A0��Ԃ�
	return 0;
}

// �w���̃f�[�^�̎擾
student* get(int id) {
	int i;
	for (i = 0; i < num_of_students; i++) {
		// �Y������id�̃f�[�^������������
		if (student_database[i].id == id) {
			return &student_database[i];		// �|�C���^��Ԃ�
		}
	}
	return NULL;
}
