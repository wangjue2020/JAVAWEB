<%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-11
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()
            +"://"
            + request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";
    request.setAttribute("basePath", basePath);
%>
<base href="${basePath}"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="static/script/jquery-1.7.2.js"></script>
