<%@page contentType="text/html; charset=Shift_JIS" %>
<%@page import="java.sql.*" %>
<html>
<head><title>データベース接続</title></head>
<body>
<h2>JSPでデータベースに接続(JDBC)</h2>
<%!
    String url = "jdbc:odbc:URIAGE";
    String user = "";
    String password = "";
    Connection con = null;
%>
<table>
<%
    // JDBCドライバをロードする
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

    // データベースに接続する
    con = DriverManager.getConnection(url, user, pass);

    // Statementオブジェクトの生成
    Statement stmt = con.createStatement();

    // SQL実行
    String query = "SELECT * FROM SHOHINM ORDER BY SHOHINCD DESC";
    ResultSet rs = stmt.executeQuery(query);

    // 検索結果の取り出し
    while(rs.next()) {
        String shohincd = rs.getString("SHOHINCD");
        String shohinmei = rs.getString("SHOHINMEI");
        int tanka = rs.getInt("TANKA");
%>
<tr>
<td><%= shohincd %></td>
<td><%= shohinmei %></td>
<td><%= tanka %></td>
</tr>
<%
    }
%>
</table>
</body></html>

<%
    rs.close();
    stmt.close();
    // データベースから切断する
    con.close();
%>
