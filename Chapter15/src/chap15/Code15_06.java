package chap15;

public class Code15_06 {
	public static void main(String[] args) {
		System.out.println(isValidPlayerName("MINATO01"));
		System.out.println(isValidPlayerName("あいうえお"));
	}
	
	public static boolean isValidPlayerName(String name) {
		return name.matches("[A-Z][A-Z0-9]{7}");
	}
}
