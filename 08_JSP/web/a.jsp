<%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-06
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         errorPage="/error.jsp"
         import="java.util.Map" %>

<!--
errorPage表示错误后自动跳转去的路径 <br/> 这个路径一般都是以斜杠打头，
它表示请求地址为 http://ip:port/工程路径/   映射到代码的web目录
-->
<html>
<head>
    <title>Title</title>
</head>
<body>
This is jsp page content
<%
    int i = 1/0;
%>
</body>
</html>
