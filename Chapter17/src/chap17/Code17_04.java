package chap17;

import java.io.*;

public class Code17_04 {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("A:\\data.txt");
			fw.write("hello!");
		} catch (IOException e) {
			System.out.println("エラーです");
		}
		fw.close();
	}
}
