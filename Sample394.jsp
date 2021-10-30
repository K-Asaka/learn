<%@page contentType="text/html; charset=Shift_JIS" %>
<html>
<head><title>簡易アクセスカウンター</title></head>
<body>
<h3>
<h2>簡易セッションアクセスカウンター</h2>
<%
    session = request.getSession(true);
    Integer num = (Integer)session.getAttribute("test.counter");
    if (num == null) {
        num = new Integer(1);
    } else {
        num = new Integer(num.intValue() + 1);
    }
    session.setAttribute("test.counter", num);
%>
<%= num %>回カウントしました
</h3>
</body>
</html>
