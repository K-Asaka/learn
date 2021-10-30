import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Sample379 extends HttpServlet {
    Connection con = null;
    public void init() {
        try {
            // JDBCドライバをロードする
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // データベースに接続する
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String password = "";
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }

    public void destroy() {
        try {
            // データベースから切断する
            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
        res.setContentType("text/html; charset=Shift_JIS");
        try {
            // Statementオブジェクトを作成
            Statement stmt = con.createStatement();

            // SQL実行
            String query = "SELECT * FROM SHOHINM ORDER BY SHOHINCD";
            ResultSet rs = stmt.executeQuery(query);

            PrintWriter out = res.getWriter();
            out.println("<html><head>");
            out.println("<title>データベース接続</title>");
            out.println("</head><body>");
            out.println("<h2>");
            out.println("サーブレットでデータベースに接続(JDBC)");
            out.println("</h2>");
            out.println("<table>");

            // 検索結果の取り出し
            while (rs.next()) {
                out.println("<tr>");
                String shohincd = rs.getString("SHOHINCD");
                out.println("<td>" + shohincd + "</td>");
                String shohinmei = rs.getString("SHOHINMEI");
                out.println("<td>" + shohinmei + "</td>");
                int tanka = rs.getInt("TANKA");
                out.println("<td>" + tanka + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body></html>");

            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
