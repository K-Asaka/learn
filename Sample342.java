import java.net.*;
import java.sql.*;
public class Sample342 {
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
            String query = "SELECT SHOHINCD FROM SHOHINM ORDER BY SHOHINCD ASC";

            ResultSet rs = stmt.executeQuery(query);
            System.out.println("SHOHINCDを昇順に並べ替えます");
            while (rs.next()) {
                shohincd = rs.getString("SHOHINCD");
                System.out.println(shohincd);
            }

            // SQL文
            query = "SELECT SHOHINCD FROM SHOHINM ORDER BY SHOHINCD DESC";

            rs = stmt.executeQuery(query);
            System.out.println("SHOHINCDを降順に並べ替えます");
            while (rs.next()) {
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
