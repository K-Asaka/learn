package chap17;

import java.io.*;

public class Code17_08 {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("A:\\data.txt");
			fw.write("hello!");
		} catch (Exception e) {
			System.out.println("何らかの例外が発生しました");
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				;
			}
		}
	}
}
