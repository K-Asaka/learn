import java.net.*;
import java.sql.*;
public class Sample333 {
    public static void main(String[] args) {
        try {
            String shohincd;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
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

            // 先頭にカーソルを移動する
            rs.absolute(1);

            // 相対位置にカーソルを移動する
            System.out.print("先頭から2番目に移動:");
            rs.relative(2);
            shohincd = rs.getString("SHOHINCD");
            System.out.println(shohincd);
            System.out.print("続けて、4行次に移動:");
            rs.relative(4);
            shohincd = rs.getString("SHOHINCD");
            System.out.println(shohincd);
            System.out.print("続けて、3行前に移動:");
            rs.relative(-3);
            shohincd = rs.getString("SHOHINCD");
            System.out.println(shohincd);
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
