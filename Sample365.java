import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample365 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>サーブレットからパラメータを受信</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>受信したパラメータ</h1>");
        out.println("<h2>");
        out.println(req.getParameter("param"));
        out.println("</h2>");
        out.println("</body></html>");
    }
}
