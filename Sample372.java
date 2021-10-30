import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample372 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>HTTPリクエストのヘッダ情報を取得</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>HTTPリクエストのヘッダ情報</h2>");

        // HTTPメソッドの表示
        out.println("<h5>" + "HTTPメソッド：");
        out.println(req.getMethod());
        out.println("<br></h5>");

        // リクエストの全ヘッダ名を取得
        Enumeration enum = req.getHeaderNames();

        // Enumerationオブジェクトからヘッダ名を取り出す
        String name;
        String value;
        while (enum.hasMoreElements()) {
            // 各ヘッダ名から値を取得
            name = (String)enum.nextElement();
            value = req.getHeader(name);
            out.println("<b>" + name + "：</b>" + value + "<br>");
        }
        out.println("</body></html>");
        out.close();
    }
}
