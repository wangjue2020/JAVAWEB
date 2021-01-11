<%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-10
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "pageContext");
    session.setAttribute("key", "pageContext");
    application.setAttribute("key", "pageContext");
%>
<%--
     当四个域中都有相同的key的数据的时候，EL表达式会按照四个域的从小到大的顺序去进行搜索，找到就输出。
     --%>
${key}
</body>
</html>
