<%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-09
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope.jsp page</h1>

pageContext scope has value ? <%=pageContext.getAttribute("key")%><br>
request scope has value? <%=request.getAttribute("key")%><br>
session scope has value? <%=session.getAttribute("key")%><br>
application scope has value? <%=application.getAttribute("key")%><br>
</body>
</html>
