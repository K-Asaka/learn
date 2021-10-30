import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample364 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        // 日本語メッセージを正しく表示
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>サーブレットのデバッグ</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("デバック開始<br>");
        // コンソールに出力
        System.out.println("Debug Start!");
        out.println("メイン処理実行<br>");
        out.println("デバック終了");
        // コンソールに出力
        System.out.println("Debug End!");
        out.println("</body></html>");
    }
}
