import java.net.*;
import java.sql.*;
public class Sample343 {
    public static void main(String[] args) {
        try {
            String shohincd;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();

            // SQL文
            String query = "INSERT INTO URIAGE (DENPYONO, SHOHINCD, SURYO)";
            query += "VALUES ('000001', '0001', 20)";
            int num = stmt.executeUpdate(query);
            System.out.println(num + "件追加しました");

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
