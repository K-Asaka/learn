#include <stdio.h>
#include <stdint.h>

// Rust�Ɠ�����`������
struct point {
    int x;
    int y;
};

// Rust�̊֐��̃v���g�^�C�v�錾
// ���struct point�Ƃ���͒��J�ɂ��Ȃ�w�b�_�����ׂ�
double
dist(struct point *, struct point *);


int
main()
{
    struct point p1 = {1, 0}, p2 = {0, 1};
    double ret;

    ret = dist(&p1, &p2);

    printf("%f\n", ret);
}