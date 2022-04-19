import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class URLtest {
    public static void main(String[] args) {
        URL u = null;
        try {
            u = new URL("https://www.gihyo.co.jp/");
        } catch (MalformedURLException e) {
            System.out.println("URLが正しくありません。");
            System.exit(0);
        }
        try (
            InputStream in = u.openStream();
            InputStreamReader is = new InputStreamReader(in);
        ) {
            BufferedReader br = new BufferedReader(is);
            String s;

            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("I/Oエラーが発生しました。");
        }
    }
}
