import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample362 extends HttpServlet {
    private String contextParam;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        contextParam = config.getServletContext().getInitParameter("contextParam");
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>context初期化パラメータを取得する</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>contextParam</h1>");
        out.println("<h2>");
        out.println(contextParam);
        out.println("</h2>");
        out.println("</body></html>");
    }
}
