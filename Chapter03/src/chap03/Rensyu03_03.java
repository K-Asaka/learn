package chap03;

public class Rensyu03_03 {
	public static void main(String[] args) {
		int isHungry = 1;
		String food = "おにぎり";
		
		System.out.println("こんにちは");
		if (isHungry == 0) {
			System.out.println("お腹がいっぱいです");
		} else {
			System.out.println("はらぺこです");
		}
		if (isHungry == 1) {
			System.out.println(food + "をいただきます");
		}
		System.out.println("ごちそうさまでした");
	}
}
