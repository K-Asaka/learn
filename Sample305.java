import java.net.*;
import java.io.*;
public class Sample305 {
    public static void main(String[] args) {
        try {
            URL u = new URL("file:/C:\\sample.txt");
            Object obj = u.getContent();
            if (obj instanceof InputStream) {
                BufferedReader br = new BufferedReader(new InputStreamReader((InputStream)obj));
                String line;
                while ((line = br.readLine()) != null)
                    System.out.println(line);
                br.close();
            } else {
                System.out.println("Content=" + obj.toString());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("例外" + e + "が発生しました");
        } catch (IOException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
