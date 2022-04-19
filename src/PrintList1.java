import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class PrintList1 {
    public static void main(String[] args) {
        FileReader fr = null;

        try {
            fr = new FileReader(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("ファイルが見つかりません。");
            System.exit(0);
        }

        Scanner sin = new Scanner(fr);
        while (sin.hasNext()) {
            String s = sin.nextLine();
            System.out.println(s);
        }
        sin.close();
        if (fr != null) {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("I/Oエラーが発生しました。");
            }
        }
    }
}
