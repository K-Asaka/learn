<%@page contentType="text/html; charset=Shift_JIS" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.Locale" %>
<%
    SimpleDateFormat jsdformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss(E)", Locale.JAPAN);
    SimpleDateFormat usdformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss(E)", Locale.US);
%>
<html>
<head><title>日付をフォーマットして表示する</title></head>
<body>
<h3>
<h2>システム日付をフォーマットして表示</h2>
<%
    Date date = new Date();
%>
ロケールを日本に指定して表示：
<%=
    jsdformat.format(date)
%>
<br>
ロケールを米国に指定して表示
<%=
    usdformat.format(date)
%>
</h3>
</body>
</html>
