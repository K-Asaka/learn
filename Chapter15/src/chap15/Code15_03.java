package chap15;

public class Code15_03 {
	public static void main(String[] args) {
		String s1 = "Java programming";
		System.out.println("文字列s1の4文字目以降は"
				+ s1.substring(3));
		System.out.println("文字列s1の4～8文字目は"
				+ s1.substring(3, 8));
	}
}
