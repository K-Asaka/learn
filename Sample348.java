import java.sql.*;
public class Sample348 {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:URIAGE";
            String user = "";
            String pass = "";
            con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();

            // パラメータ付きSQLを作成
            String query = "INSERT INTO URIAGE ";
            query += "(DENPYONO, SHOHINCD, SURYO) VALUES (?, ?, ?)";

            // PreparedStatementオブジェクトを作成
            PreparedStatement stmt = con.prepareStatement(query);

            // 追加するデータを配列にセット
            String denpyono[] = {"100000", "200000", "300000"};
            String shohincd[] = {"0001", "0002", "0003"};
            int suryo[] = {100, 200, 300};

            // データを追加します
            for (int i = 0; i < denpyono.length; i++) {
                stmt.setString(1, denpyono[i]);
                stmt.setString(2, shohincd[i]);
                stmt.setInt(3, suryo[i]);
                stmt.executeUpdate();
                System.out.println((i + 1) + " 件目のデータを追加終了");
            }

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
