<%@page contentType="text/html; charset=Shift_JIS" %>
<html>
<head><title>サーブレットから呼び出すJSP</title></head>
<body>
<h3>
<h2>サーブレットから呼び出すJSP</h2>
サーブレットから受け取ったデータ：
<%
    out.print(request.getAttribute("servletparam").toString());
%>
</h3>
</body>
</html>
