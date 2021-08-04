package chap18;

import java.io.*;

public class Code18_02 {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("data.txt");
		fw.write('そ');
		fw.write('れ');
		fw.write('で');
		fw.write('は');
		fw.close();
	}
}
