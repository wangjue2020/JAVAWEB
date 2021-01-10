<%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-09
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.getWriter().write("response output 1 <br/>");
    response.getWriter().write("response output 2 <br/>");

    out.print("out output 1<br/>");
    out.print("out output 2<br/>");
%>
</body>
</html>
