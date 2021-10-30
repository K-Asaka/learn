<%@page contentType="text/html; charset=Shift_JIS" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.Locale" %>
<%
    SimpleDateFormat sdformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss(E)", Locale.JAPAN);
%>
<html>
<head><title>セッション情報を表示</title></head>
<body>
<h3>
<h2>セッション情報</h2>
<%
    session = request.getSession(true);
    boolean isnew = session.isNew();
    String sessionid = session.getId();
    long creattiontime = session.getCreationTime();
    long lastaccessedtime = session.getLastAccessedTime();
    int maxinactiveinterval = session.getMaxInactiveInterval();
%>
既存のセッションかどうか：
<%= isnew %><br>
セッションID：
<%= sessionid %><br>
作成日時：
<%= sdformat.format(new Date(creattiontime)) %><br>
最終アクセス日時：
<%= sdformat.format(new Date(lastaccessedtime)) %><br>
インターバル時間：
<%= maxinactiveinterval %><br>
</h3>
</body>
</html>
