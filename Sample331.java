import java.net.*;
import java.sql.*;
public class Sample331 {
    public static void main(String[] args) {
        try {
            String shohincd;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            // Statementオブジェクトを作成
            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            String query = "SELECT * FROM SHOHINM";
            ResultSet rs = stmt.executeQuery(query);
            // 検索結果の取り出し
            while (rs.next()) {
                shohincd = rs.getString("SHOHINCD");
                System.out.println(shohincd);
            }
            System.out.println("---------");
            // 検索結果を逆順に取り出す
            while (rs.previous()) {
                shohincd = rs.getString("SHOHINCD");
                System.out.println(shohincd);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
