package chap17;

import java.io.*;

public class Code17_01 {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("A:\\data.txt");
		} catch (IOException e) {
			System.out.println("エラーが発生しました。");
		}
	}
}
