import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample398 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        // JSPを呼び出す
        res.sendRedirect("/java/sample/398/Sample398.jsp");
    }
}
