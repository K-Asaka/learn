package chap17;

import java.io.*;

public class Code17_05 {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("A:\\data.txt");
			fw.write("hello!");
		} catch (Exception e) {
			System.out.println("何らかの例外が発生しました");
		} finally {
			fw.close();
		}
	}
}
