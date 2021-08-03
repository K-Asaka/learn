package chap15;

public class Rensyu15_01 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			sb.append(i + 1).append(",");
		}
		String s = sb.toString();
		String[] a = s.split(",");
	}
}
