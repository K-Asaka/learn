import java.io.*;
public class Sample287 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("sample.txt");
            StreamTokenizer st = new StreamTokenizer(fr);

            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println("数字:" + Double.toString(st.nval));
                } else {
                    System.out.println("文字列:" + st.sval);
                }
            }
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
