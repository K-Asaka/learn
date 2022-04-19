import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class PrintList2 {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader(args[0]);
             Scanner sin = new Scanner(fr);) {
            while (sin.hasNext()) {
                String s = sin.nextLine();
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ファイルが見つかりません。");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("I/Oエラーが発生しました。");
        }
    }
}
