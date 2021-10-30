import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample371 extends HttpServlet {
    int cnt;
    public void init() throws ServletException {
        cnt = 0;
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>簡易アクセスカウンター</title>");
        out.println("</head>");
        out.println("<body>");

        // カウンターを表示する
        out.println("<h2>");
        out.println(cnt + "回カウントしました");
        out.println("</h2>");
        out.println("</body></html>");

        // カウンターを進める
        cnt++;

        out.close();
    }
}
