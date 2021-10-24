import java.net.*;
import java.sql.*;
public class Sample345 {
    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();

            // SQL文
            String query = "DELETE FROM URIAGE ";
            query += "WHERE DENPYONO = '000001'";
            int num = stmt.executeUpdate(query);
            System.out.println(num + "件削除しました");
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
