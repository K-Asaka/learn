import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample368 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>サーブレットから複数のパラメータを受信</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>受信したパラメータ</h1>");
        out.println("<h2>");
        String selectedParams[] = req.getParameterValues("MLIST");
        for (int i = 0; i < selectedParams.length; i++) {
            out.println(selectedParams[i] + "<br>");
        }
        out.println("</h2>");
        out.println("</body></html>");
    }
}
