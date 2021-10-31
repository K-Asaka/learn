<%@page contentType="text/html; charset=Shift_JIS" %>
<html>
<head><title>JSPのログ出力</title></head>
<body>
<h2>ログ出力テスト</h2>
Log Test1出力<br>
<%
    application.log("Log Test1");
%>
メイン処理実行<br>
Log Test2出力<br>
<%
    application.log("Log Test2");
%>
</body></html>
