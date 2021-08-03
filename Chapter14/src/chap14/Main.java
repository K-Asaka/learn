package chap14;

public class Main {
	public static void main(String[] args) {
		Object o1 = new Empty();
		Object o2 = new Hero();
		Object o3 = "こんにちは";
	}
	
	public void printAnything(Object o) {
		// 何型でもいいから、引数を1つ受け取り画面に表示
		System.out.println(o.toString());
	}
}
