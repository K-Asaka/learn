#include <stdio.h>
#include <string.h>

// 学生のデータを入れる構造体
struct student{
	int id;			// 学生番号
	char name[256];	// 名前
	int age;		// 年齢
};

int main(int argc, char** argv) {
	// 構造体変数の宣言
	struct student data;
	// メンバに値を代入
	data.id = 1;						// 学生番号:1
	strcpy(data.name, "山田太郎");		// 名前:山田太郎
	data.age = 18;						// 年齢:18
	// データの内訳を表示
	printf("学生番号:%d 名前:%s 年齢:%d\n", data.id, data.name, data.age);
	return 0;
}