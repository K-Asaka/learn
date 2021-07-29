package chap03;

public class Rensyu03_01 {
	public static void main(String[] args) {
		int weight = 30;
		int age1 = 20;
		int age2 = 24;
		int age = 21;
		String name = "ミナト";
		
		System.out.println("変数weightの値が60に等しい:" + (weight == 60));
		System.out.println("変数age1と変数age2の合計を2倍したものが60を超えている:"
					+ ((age1 + age2) * 2 > 60));
		System.out.println("変数ageが奇数である:" + (age % 2 == 1));
		System.out.println("変数nameの中身の文字列が「湊」と等しい:" + name.equals("湊"));
	}
}
