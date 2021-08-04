package chap17;

import java.io.*;

public class Code17_07 {
	public static void main(String[] args) {
		FileWriter fw;
		try {
			fw = new FileWriter("A:\\data.txt");
			fw.write("hello!");
		} catch (IOException e) {
			System.out.println("エラーです");
		} finally {
			//fw.close();
		}
	}
}
