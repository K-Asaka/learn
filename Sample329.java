import java.net.*;
import java.sql.*;
public class Sample329 {
    public static void main(String[] args) {
        try {
            // JDBCドライバをロードする
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            // データベースに接続する
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("データベースに接続しました");
            // データベースから切断する
            con.close();
            System.out.println("データベースを切断しました");
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
