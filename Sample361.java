import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample361 extends HttpServlet {
    private String servletParam;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletParam = config.getInitParameter("servletParam");
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>servlet初期化パラメータを取得する</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>servletParam</h1>");
        out.println("<h2>");
        out.println(servletParam);
        out.println("</h2>");
        out.println("</body></html>");
    }
}
