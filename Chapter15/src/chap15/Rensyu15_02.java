package chap15;

public class Rensyu15_02 {
	public static void main(String[] args) {
		String file = "readme.txt";
		System.out.println(concatPath("c:\\javadev", file));
		System.out.println(concatPath("c:\\user\\", file));
	}
	
	public static String concatPath(String folder, String file) {
		if (!folder.endsWith("\\")) {
			folder += "\\";
		}
		return folder + file;
	}
}
