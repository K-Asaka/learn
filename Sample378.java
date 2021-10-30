import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample378 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");

        String cname = "TestCount"; // テストサイト用Cookieの名前
        int num = 0;    // アクセスしたことのある回数

        // クッキーの一覧にテストサイト用のクッキーがあるか検索する
        Cookie cookies[] = null;
        if ((cookies = req.getCookies()) != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(cname)) {
                    num = Integer.parseInt(cookies[i].getValue());
                }
            }
        }

        num++;  // アクセス回数を加算

        // メッセージの設定
        String msg = Integer.toString(num) + "回目の訪問ありがとう";

        // 有効期限が無期限のクッキーをクライアントに送信
        Cookie cookie = new Cookie(cname, Integer.toString(num));
        cookie.setMaxAge(Integer.MAX_VALUE);
        res.addCookie(cookie);

        // HTMLを表示
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>サイトの訪問回数を表示する</title>");
        out.println("</head><body>");
        out.println("<h2>テストサイトへようこそ</h2>");
        out.println(msg);
        out.println("</body></html>");
        out.close();
    }
}
