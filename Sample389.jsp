<%@page import="java.util.*"
contentType="text/html; charset=Shift_JIS" %>
<html>
<head><title>JSPの変数</title></head>
<body>
<h1>
<%
    Calendar cal = Calendar.getInstance();
    int y = cal.get(Calendar.YEAR);
    int m = cal.get(Calendar.MONTH) + 1;
    int d = cal.get(Calendar.DATE);
    out.println("今日は" + y + "年" + m + "月" + d + "日です");
%>
</h2>
</body>
</html>
