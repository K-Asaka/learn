package chap05;

public class Code05_07 {
	public static int add(int x, int y) {
		int ans = x + y;
		return ans;
	}
	
	public static void main(String[] args) {
		int ans = add(100, 10);
		System.out.println("100 + 10 = " + ans);
	}
}
