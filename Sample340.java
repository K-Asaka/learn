import java.net.*;
import java.sql.*;
public class Sample340 {
    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            // SQL文
            String query = "SELECT * FROM SHOHINM ";
            query += "WHERE SHOHINCD = '0007' OR SHOHINMEI = 'SHOHIN0008'";

            ResultSet rs = stmt.executeQuery(query);
            System.out.println("SHOHINCD SHOHINMEI  TANKA");
            System.out.println("-------------------------");
            while (rs.next()) {
                String shohincd = rs.getString("SHOHINCD");
                String shohinmei = rs.getString("SHOHINMEI");
                int tanka = rs.getInt("TANKA");
                System.out.print(shohincd + "     ");
                System.out.print(shohinmei + " ");
                System.out.println(tanka);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
