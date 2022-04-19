import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class ExceptionDemo2 {
    public static void main(String[] args) {
        Scanner sc = null;
        FileReader fr = null;
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            System.out.println("ファイルが見つかりません");
        } finally {
            if (sc != null) {
                sc.close();
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("I/Oエラーが発生しました");
            }
        }
    }
}
