import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample355 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        // ヘッダに出力形式をセット
        res.setContentType("text/html");
        // 出力ストリームを作成
        PrintWriter out = res.getWriter();
        // HTML文を出力
        out.println("<html><head>");
        out.println("<title>Hello Servlet!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello Java Servlet!</h1>");
        out.println("</body></html>");
    }
}
