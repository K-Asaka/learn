import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample377 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");

        // 送信されてきたクッキーを取得
        Cookie cookies[] = req.getCookies();

        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>クライアントのクッキー情報を取得する</title>");
        out.println("</head><body>");
        out.println("<h2>クライアントのクッキー情報</h2>");
        if (cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                out.print("Name = " + cookies[i].getName() + " : ");
                out.println("Value = " + cookies[i].getValue() + "<br>");
            }
        } else {
            out.println("クッキーは存在しません");
        }
        out.println("</body></html>");
        out.close();
    }
}
