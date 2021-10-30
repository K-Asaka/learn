import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample376 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");

        // 現在使用中のブラウザを使用している間のみ有効なクッキーを作成
        Cookie cookie1 = new Cookie("TestCookie1", Integer.toString(1));
        res.addCookie(cookie1);

        // 有効期限が10秒のクッキーを作成
        Cookie cookie2 = new Cookie("TestCookie2", Integer.toString(2));
        cookie2.setMaxAge(10);
        res.addCookie(cookie2);

        // 有効期限が無期限のクッキーを作成
        Cookie cookie3 = new Cookie("TestCookie3", Integer.toString(3));
        cookie3.setMaxAge(Integer.MAX_VALUE);
        res.addCookie(cookie3);
        
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>クッキーをクライアントに送る</title>");
        out.println("</head><body>");
        out.println("<h2>3つのクッキーを送信しました</h2><br>");
        out.println("</body></html>");
        out.close();
    }
}
