import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sample375 extends HttpServlet {

    public static final String txtpath = "C:\\java\\sample\\375\\sample.txt";

    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        // HTML表示
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>テキストファイルの入出力</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form method=\"post\" action=\"Sample375\">");
        out.println("<h2>テキスト入出力</h2><br>");
        out.println("書き込む文字列 <input type=\"text\" name=\"txtdata\">");
        out.println("<br>");
        out.println("<input type=\"submit\" value=\"書き込む\"><br></form>");
        out.println("</body></html>");
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        // HTML出力
        res.setContentType("Content-Type: text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>テキストファイルの入出力</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>テキスト入出力</h2><br>");

        out.println("テキストファイルに書き込みます<br><hr>");
        // 入力文字列を取得
        String txtstr = req.getParameter("txtdata");
        // 文字列をテキストファイルへ書き込む
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(txtpath)));
        pw.println(txtstr);
        pw.flush();
        pw.close();

        out.println("テキストファイルを読み込みます<br><hr>");
        // テキストファイルの文字列を読み込む
        try {
            BufferedReader br = new BufferedReader(new FileReader(txtpath));
            String str = br.readLine();
            out.println(str);
            br.close();
        } catch (IOException e) {
            System.out.println("例外" + e + "が発生しました");
        }

        out.println("</body></html>");
        out.close();
    }
}
