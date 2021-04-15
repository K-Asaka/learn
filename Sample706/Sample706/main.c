#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// �f�[�^�x�[�X�ɓo�^�ł���w���̍ő吔
#define MAX_STUDENT 10
// �w���̖��O�̍ő�̒���
#define LENGTH		50
// �G���[���b�Z�[�W�̕�����̍ő�̒���
#define MESSAGE_LENGTH 256

// �G���[���b�Z�[�W
enum ERROR {
	MESSAGE_OK,
	MESSAGE_ERROR
};

// �w���̃f�[�^
typedef struct {
	int id;				// �w���ԍ�
	char name[LENGTH];	// ���O
} student;

// �f�[�^�x�[�X�ɓo�^����Ă���w���̐�
int num_of_students = 0;
// �w���̃f�[�^
student student_database[MAX_STUDENT];
// �G���[�ԍ�
int Error;

// �f�[�^�x�[�X�̏�����
void initDatabase();
// �f�[�^�x�[�X�ւ̃f�[�^�̓o�^(�w���ԍ��A���O)
int add(int, char*);
// �w���̃f�[�^�̎擾
student* get(int);
// �w���f�[�^�̕\��
void showStudentData(student*);
// �G���[�̕\��
void showError();


int main(int argc, char** argv) {
	int i;
	char names[][LENGTH] = {
		"�R�c���Y", "���c���q�q", "��R���Y", "�R�����₩"
	};
	int ids[] = { 1, 2, 3, 3 };
	initDatabase();
	for (i = 0; i < 4; i++) {		// �f�[�^�̓o�^
		add(ids[i], names[i]);
		printf("�o�^:%d %s\n", ids[i], names[i]);
		showError();
	}
	for (i = 0; i < 3; i++) {		// �o�^�����f�[�^�̏o��
		showStudentData(get(i + 1));
	}
	return 0;
}

// �f�[�^�x�[�X�̏�����
void initDatabase() {
	int i;
	for (i = 0; i < MAX_STUDENT; i++) {
		student_database[i].id = -1;
		strcpy(student_database[i].name, "");
	}
	Error = MESSAGE_OK;			// �G���[���b�Z�[�W�̃N���A
	num_of_students = 0;		// �o�^���ꂽ�w���̐���0�ɏ�����
}

// �f�[�^�x�[�X�ւ̃f�[�^�̓o�^(�w���ԍ��A���O)
int add(int id, char* name) {
	// ���łɓo�^����Ă���id�ł���΁A�o�^���Ȃ�
	if (get(id) == NULL && num_of_students < MAX_STUDENT) {
		student_database[num_of_students].id = id;
		strcpy(student_database[num_of_students].name, name);
		num_of_students++;
		Error = MESSAGE_OK;
		// �o�^�ł�����1��Ԃ�
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

// �w���f�[�^�̕\��
void showStudentData(student* data) {
	if (data != NULL) {
		printf("�w���ԍ�:%d ���O:%s\n", data->id, data->name);
	}
	else {
		printf("�f�[�^���o�^����Ă��܂���B\n");
	}
}

// �G���[�̕\��
void showError() {
	switch (Error) {
	case MESSAGE_OK:
		printf("OK!\n");
		break;
	case MESSAGE_ERROR:
		printf("ERROR!\n");
		break;
	}
}

