<%@ page import="com.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-10
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border:1px black solid;
            width:600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px black solid;

        }
    </style>
</head>
<body>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("resultOfStudent");
%>
<table >
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    <%
        for (Student s: studentList){
     %>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <td><%=s.getAge()%></td>
                <td><%=s.getPhone()%></td>
                <td><a>Delete/Edit</a></td>
            </tr>
    <%

        }
    %>
</table>
</body>
</html>
