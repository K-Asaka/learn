package main

import "fmt"

// 新しい型を宣言する
type person struct {
	name string
	age  int
}

// Skills Skills型の宣言
// 匿名によるアクセスとフィールドの修正はとても便利。
// 単なるstructのフィールドなので、すべてのビルトイン型と自分で定義した型をすべて匿名フィールドとみなすことができる。
type Skills []string

// Human 人構造体
type Human struct {
	name   string
	age    int
	weight int
}

// Student 学生構造体
type Student struct {
	Human      // 匿名フィールド、デフォルトでStudentはHumanのすべてのフィールドを持つ
	speciality string
}

// Student2 学生構造体。匿名フィールド追加分
type Student2 struct {
	Human      // 匿名フィールド、デフォルトでStudentはHumanのすべてのフィールドを持つ
	Skills     // 匿名フィールド、自分で定義した型。string slice
	int        // ビルトイン型を匿名フィールドとする
	speciality string
}

// Human2 人構造体(phone)
type Human2 struct {
	name  string
	age   int
	phone string // Human2型がもつフィールド
}

// Employee 社員構造体
type Employee struct {
	Human2     // 匿名フィールドHuman2
	speciality string
	phone      string // 社員のphoneフィールド
}

// Older 二人の年齢を比較する。年齢が大きい方の人を返し、また年齢差も返す。
// structも値渡し
func Older(p1, p2 person) (person, int) {
	if p1.age > p2.age { // p1とp2の二人の年齢を比較
		return p1, p1.age - p2.age
	}
	return p2, p2.age - p1.age
}

func main() {
	var tom person

	// 初期値を代入する
	tom.name, tom.age = "Tom", 18

	// 2つのフィールドを明確に初期化する
	bob := person{age: 25, name: "Bob"}

	// structの定義の順番に従って初期化する
	paul := person{"Paul", 43}

	tbOlder, tbDiff := Older(tom, bob)
	tpOlder, tpDiff := Older(tom, paul)
	bpOlder, bpDiff := Older(bob, paul)

	fmt.Printf("Of %s and %s, %s is older by %d years\n", tom.name, bob.name, tbOlder.name, tbDiff)
	fmt.Printf("Of %s and %s, %s is older by %d years\n", tom.name, paul.name, tpOlder.name, tpDiff)
	fmt.Printf("Of %s and %s, %s is older by %d years\n", bob.name, paul.name, bpOlder.name, bpDiff)

	//var P person // Pは現在person型の変数
	//P.name = "Astaxie"                            // 変数Pのnameプロパティに代入
	//P.age = 25                                    // 変数Pのageプロパティに代入
	// このような宣言以外に他にもいくつかの宣言方法がある
	// 1.順序に従って初期化する
	// P := person{"Tom", 25}
	// 2.field:valueの方法によって初期化する。順序は任意でかまわない。
	// P := person{age:24, name:"Tom"}
	// 3.new関数を通してポインタを作ることもできる。このPの型は*person。
	// P := new(person)
	//fmt.Printf("The person's name is %s", P.name) // Pのnameプロパティにアクセスする

	// 学生を一人初期化する
	mark := Student{Human{"Mark", 25, 120}, "Computer Science"}

	// 対応するフィールドにアクセスする
	fmt.Println("His name is ", mark.name)
	fmt.Println("His age is ", mark.age)
	fmt.Println("His weight is ", mark.weight)
	fmt.Println("His speciality is ", mark.speciality)
	// 対応するメモ情報を修正する
	mark.speciality = "AI"
	fmt.Println("Mark changed his speciality")
	fmt.Println("His speciality is ", mark.speciality)
	// 彼の年齢情報を修正する
	fmt.Println("Mark become old")
	mark.age = 46
	fmt.Println("His age is ", mark.age)
	// 体重情報も修正する
	fmt.Println("Mark is not an athlet anymore")
	mark.weight += 60
	fmt.Println("His weight is ", mark.weight)

	// Studentがageとnameの属性にアクセスする際、あたかも自分のフィールドであるかのようにアクセスする。
	// 匿名フィールドはフィールドの継承を実現できる。
	// studentはHumanのフィールド名でアクセスできる。
	mark.Human = Human{"Marcus", 55, 220}
	fmt.Println("----", mark.Human.age)
	mark.Human.age -= 3
	fmt.Println("----", mark.Human.age)

	// 学生Jannを初期化する
	jane := Student2{Human: Human{"Jane", 35, 100}, speciality: "Biology"}
	// ここで対応するフィールドにアクセスする
	fmt.Println("Her name is ", jane.name)
	fmt.Println("Her age is ", jane.age)
	fmt.Println("Her weight is ", jane.weight)
	fmt.Println("Her speciality is ", jane.speciality)
	// 彼女のskill技能フィールドを修正する
	jane.Skills = []string{"anatomy"}
	fmt.Println("Her skills are ", jane.Skills)
	fmt.Println("She acquired two new ones")
	// 対応するフィールド上で関数操作を行うことができる
	jane.Skills = append(jane.Skills, "physics", "golang")
	fmt.Println("Her skills now are ", jane.Skills)
	// 匿名ビルトイン型のフィールドを修正する
	jane.int = 3
	fmt.Println("Her preferred number is ", jane.int)

	// もしhumanにphoneというフィールドがあり、studentもphoneというフィールドがあった場合はどうするか。
	// Goでは、外側が優先的にアクセスされるため、student.phoneとアクセスした場合、studentの中のフィールドにアクセスし、humanのフィールドにはアクセスしない。
	// 以下はHuman2とEmployeeを使った例
	Bob := Employee{Human2{"Bob", 34, "777-444-XXXX"}, "Designer", "333-222"}
	fmt.Println("Bob's work phone is:", Bob.phone)
	// もしHuman2のphoneフィールドにアクセスするなら
	fmt.Println("Bob's personal phone is:", Bob.Human2.phone)

}
