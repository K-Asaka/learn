import java.sql.*;
public class Sample347 {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();

            // バッチ更新するSQLをstmtオブジェクトに登録
            String str1 = "UPDATE URIAGE SET SURYO = 4000 ";
            str1 += "WHERE DENPYONO = '000002'";
            String str2 = "UPDATE URIAGE SET SURYO = 5000 ";
            str2 += "WHERE DENPYONO = '000003'";
            stmt.addBatch(str1);
            stmt.addBatch(str2);

            // 登録したSQLを実行
            int num[] = stmt.executeBatch();

            // 処理結果を表示
            for (int i = 0; i < num.length; i++) {
                System.out.println((i + 1) + "番目の処理で" + num[i] + " 件更新されました");
            }

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
