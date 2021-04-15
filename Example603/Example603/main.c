#include <stdio.h>
#include <math.h>

// 2�������W�̍\����
typedef struct {
	double x;		// x���W
	double y;		// y���W
} Point2D;

// 2�_�Ԃ̋��������߂�֐�
double distance2D(Point2D*, Point2D*);

int main(int argc, char** argv) {
	// p1,p2��2�_�Ԃ̍��W�ݒ�
	Point2D p1 = { -1.0, 0.0 }, p2 = { 2.0, 1.0 };
	double d = distance2D(&p1, &p2);
	printf("p1(%lf,%lf),p2(%lf,%lf)�Ԃ̋�����%lf�ł��B\n", p1.x, p1.y, p2.x, p2.y, d);
	return 0;
}

double distance2D(Point2D* p1, Point2D* p2) {
	double diff_x = p1->x - p2->x;
	double diff_y = p1->y - p2->y;
	double distance = sqrt(diff_x * diff_x + diff_y * diff_y);
	return distance;
}