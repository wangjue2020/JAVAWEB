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
<%@ page import="java.util.HashMap" %>

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
<%--1、声明类属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;

%>
<%--2、声明static静态代码块--%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
    }
%>
<%--3、声明类方法--%>
<%!
    public int getId(){
        return id;
    }
%>
<%--4、声明内部类--%>
<%!
    public static class InternalClass{
        private Integer stu_id;
        private String abc="abc";
    }
%>

<%--输出整型--%>
<%=12%><br>
<%--输出浮点型--%>
<%=12.0%><br>
<%--输出字符串--%>
<%="adf12"%><br>
<%--输出对象--%>
<%=map%><br>
<%=request.getParameter("Accept-Language")%><br>
<%--1、代码脚本 ------if语句 --%>
<%
    int i = 11;
    if(i==12){
        System.out.println("i equals 12");
    } else {
        System.out.println("i is not equal to 12");
    }
%>
<%--2、代码脚本 -------for循环 --%>
<%
    for(int j = 0; j <10; j++){
        System.out.println("for loop: " + j);
    }
%>
<table border="1" cellspacing="0">
<%
    for(int j = 0; j <10; j++){
%>
        <tr>
            <td>第<%=j+1%>行</td>
        </tr>

<%
        System.out.println("for loop: " + j);
    }
%>
</table>
<%--3、翻译后java文件中_jspService方法内的代码都可以写 --%>
<%
    System.out.println(request.getParameter("username"));
    System.out.println(request.getHeader("Accept-Language"));
%>
</body>
</html>
