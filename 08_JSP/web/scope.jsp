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
    <%
        //四个域中都分别保存了数据
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>
    pageContext scope has value ? <%=pageContext.getAttribute("key")%><br>
    request scope has value? <%=request.getAttribute("key")%><br>
    session scope has value? <%=session.getAttribute("key")%><br>
    application scope has value? <%=application.getAttribute("key")%><br>
    <%--
    <%
        request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>
    --%>
    <%--<jsp:forward page="/scope2.jsp"></jsp:forward> 是请求转发的标签， 他的功能就是请求转发--%>
    <%--page 属性设置请求转发的路径--%>
    <jsp:forward page="/scope2.jsp"/>

</body>
</html>
