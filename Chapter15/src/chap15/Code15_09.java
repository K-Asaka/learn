package chap15;

public class Code15_09 {
	public static void main(String[] args) {
		final String FORMAT = "%-9s %-13s 所持金%,6d";
		String s = String.format(FORMAT, "名前", "職業", 99999999);
		System.out.println(s);
	}
}
