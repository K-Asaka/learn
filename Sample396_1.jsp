<%@page contentType="text/html; charset=Shift_JIS" %>
<html>
<head><title>JSPに値を渡すJSP</title></head>
<body>
<h3>
<h2>リンクをクリックするとJSPに値を渡します</h2>
<a href="Sample396_1.jsp?param=2">JSPに値を渡す</a><br>
<%
    String str = request.getParameter("param");
    if (str != null) {
        if (str.equals("2")) {
            request.setAttribute("data", str);
%>
            <jsp:forward page="Sample396_2.jsp" />
<%
        }
    }
%>
</h3>
</body>
</html>
