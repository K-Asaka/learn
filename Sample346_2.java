import java.sql.*;
public class Sample346_2 {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String password = "";
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            // SQLのUPDATE文
            String query = "UPDATE SHOHINM SET TANKA = 2000 ";
            query += "WHERE SHOHINCD = '0001'";
            int num = stmt.executeUpdate(query);
            System.out.println(num + "件更新しました");
            // SQLのUPDATE文
            query = "UPDATE SHOHINM SET TANKA = 2000 ";
            query += "WHERE SHOHINCD = '0002'";
            num = stmt.executeUpdate(query);
            System.out.println(num + "件更新しました");

            // 配列要素に不正なアクセスをしてエラーを発生させる
            int a[] = new int[5];
            a[10] = 1;

            con.commit();
            con.setAutoCommit(true);

            stmt.close();
            con.close();
        } catch (Exception e) {
            try {
                if (con != null) {
                    System.out.println("例外" + e + "が発生しました");
                    con.rollback();
                    con.close();
                    System.out.println("処理をロールバックしました");
                }
            } catch (Exception ex) {
                System.out.println("例外" + e + "が発生しました");
            }
        }
    }
}
