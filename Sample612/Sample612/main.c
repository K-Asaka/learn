#include <stdio.h>
#include <string.h>

// 学生のデータを入れる構造体
typedef struct {
	int id;					// 学生番号
	char name[256];			// 名前
	int age;				// 年齢
} student_data;

// 構造体データを表示する関数
void setData(student_data*, int, char*, int);
void showData(student_data*);

int main(int argc, char** argv) {
	student_data data[4];
	int i;
	int id[] = { 1, 2, 3, 4, };
	char name[][256] = { "山田太郎", "佐藤良子", "太田隆", "中田優子" };
	int age[] = { 18, 19, 18, 18 };
	// データの設定
	for (i = 0; i < 4; i++) {
		setData(&data[i], id[i], name[i], age[i]);
	}
	// データの内訳を表示
	for (i = 0; i < 4; i++) {
		showData(&data[i]);
	}
	return 0;
}

// データのセット
void setData(student_data* pData, int id, char* name, int age) {
	pData->id = id;				// idのコピー
	strcpy(pData->name, name);	// nameのコピー
	pData->age = age;			// ageのコピー
}

// データの表示
void showData(student_data* pData) {
	printf("学生番号:%d 名前:%s 年齢:%d\n", pData->id, pData->name, pData->age);
}
