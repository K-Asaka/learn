import java.net.*;
import java.sql.*;
public class Sample330 {
    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            // Statementオブジェクトを作成
            Statement stmt = con.createStatement();
            // SQL実行
            String query = "SELECT * FROM SHOHINM";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("SHOHINCD SHOHINMEI  TANKA");
            System.out.println("-------------------------");
            // 検索結果の取り出し
            while (rs.next()) {
                String shohincd = rs.getString("SHOHINCD");
                String shohinmei = rs.getString("SHOHINMEI");
                int tanka = rs.getInt("TANKA");
                System.out.print(shohincd + "     ");
                System.out.print(shohinmei + " ");
                System.out.println(tanka);
            }
            // 作成したオブジェクトを解放
            rs.close();
            stmt.close();

            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
