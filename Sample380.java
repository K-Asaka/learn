import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample380 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>サーブレットのログ出力</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>ログ出力テスト</h2>");
        out.println("Log Test1出力<br>");

        // ログに出力
        log("Log Test1");
        out.println("メイン処理実行<br>");
        out.println("Log Test2出力<br>");
        // ログに出力
        log("Log Test2");
        out.println("</body></html>");
    }
}
