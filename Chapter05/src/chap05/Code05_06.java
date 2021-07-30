package chap05;

public class Code05_06 {
	public static void main(String[] args) {
		int x = 100;
		int y = 10;
		add(x, y);
	}
	
	public static void add(int x, int y) {
		int ans = x + y;
		System.out.println(x + "+" + y + "=" + ans);
	}
}
