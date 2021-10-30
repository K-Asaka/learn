import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample374 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {

        // コンテントタイプをimage/gifに設定
        res.setContentType("image/gif");

        // 出力ストリームオブジェクトを作成
        ServletOutputStream out = res.getOutputStream();

        // ファイルからGIF形式のデータを取得する
        String gifFile = "C:\\java\\sample\\374\\sample.gif";
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(gifFile));

        // 出力ストリームに書き出す
        int data;
        while ((data = in.read()) != -1) {
            out.write(data);
        }
        in.close();
    }
}
