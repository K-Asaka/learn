import java.sql.*;
public class Sample346_1 {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();

            // SQLのUPDATE文
            String query = "UPDATE URIAGE SET SURYO = 2000 ";
            query += "WHERE DENPYONO = '000002'";
            int num = stmt.executeUpdate(query);
            System.out.println(num + "件更新しました");

            // SQLのUPDATE文
            query = "UPDATE URIAGE SET SURYO = 3000 ";
            query += "WHERE DENPYONO = '000003'";
            num = stmt.executeUpdate(query);
            System.out.println(num + "件更新しました");

            // 配列要素に不正なアクセスをしてエラーを発生させる
            int a[] = new int[5];
            a[10] = 1;

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
