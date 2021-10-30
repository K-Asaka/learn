<%@page contentType="text/html; charset=Shift_JIS" %>
<html>
<head><title>ブラウザの判別</title></head>
<body>
<h3>
<h2>使用しているWebブラウザを判別します</h2>
<%
    out.print("使用中のWebブラウザは、MS Internet Explorer ");
    if (request.getHeader("USER-AGENT").ikndexOf("MSIE") != -1) {
        out.print("です");
    } else {
        out.print("ではありません");
    }
%>
</h3>
</body>
</html>
