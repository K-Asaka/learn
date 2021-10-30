<%@page contentType="text/html; charset=Shift_JIS" %>
<html>
<head><title>JSPの条件</title></head>
<body>
<h3>
<h2>条件1or2or3を選択してください</h2>
<a href="Sample389.jsp?param=1">条件1</a><br>
<a href="Sample389.jsp?param=2">条件2</a><br>
<a href="Sample389.jsp?param=3">条件3</a><br>
<%
    String str = request.getParameter("param");
    if (str != null) {
        if (str.equals("1")) {
%>
            <br>条件1が選択されました
<%
        } else if (str.equals("2")) {
%>
            <br>条件2が選択されました
<%
        } else if (str.equals("3")) {
%>
            <br>条件3が選択されました
<%
        }
    } else {
%>
        <br>選択した条件を表示
<%
    }
%>
</h3>
</body>
</html>
