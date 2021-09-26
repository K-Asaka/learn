import java.io.*;
import java.util.*;
import java.text.*;

public class Sample269 {
    public static void main(String[] args) {
        File file1 = new File("sample.txt");

        // 最終更新日時を書式設定せず表示
        System.out.print(file1.getPath() + "の最終更新日時は");
        System.out.println(file1.lastModified() + "です");

        // 最終更新日時を書式設定して表示
        Date date1 = new Date(file1.lastModified());
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        System.out.print(file1.getPath() + "の最終更新日時は");
        System.out.println(df.format(date1) + "です");
    }
}
