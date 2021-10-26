import java.io.*;
import javax.servlet.*;
import javax.servlethttp.*;
public class Sample359 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        // 日本語メッセージを正しく表示
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>こんにちは Servlet!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>こんにちは Java Servlet!</h1>");
        out.println("</body></html>");
    }
}
