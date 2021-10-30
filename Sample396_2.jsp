<%@page contentType="text/html; charset=Shift_JIS" %>
<html>
<head><title>JSPから値を受け取るJSP</title></head>
<body>
<h3>
<h2>JSPから値を受け取りました</h2>
data =
<%=
    request.getAttribute("data");
</h3>
</body>
</html>
