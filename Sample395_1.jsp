<%@page contentType="text/html; charset=Shift_JIS" %>
<html>
<head><title>JSPを呼び出すJSP</title></head>
<body>
<h3>
<h2>リンクをクリックするとJSPを呼び出します</h2>
<a href="Sample395_1.jsp?param=1">JSPを呼び出す</a><br>
<%
    String str = request.getParameter("param");
    if (str != null) {
        if (str.equals("1")) {
%>
            <jsp:forward page="Sample395_2.jsp" />
<%
        }
    }
%>
</h3>
</body>
</html>
