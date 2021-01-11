<%@ page import="com.bean.Student" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-11
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table, td,th{
            border:1px cornflowerblue solid;
        }
    </style>
</head>
<body>
<%--
<c:set /> 作用：set标签可以往域中保存数据
域对象.setAttribute(key,value);
    scope 属性设置保存到哪个域
        page 表示pageContext（默认值）
        request表示Request域
        session表示Session域
        application表示ServletContext域
    var设置key
    value设置value值

--%>
before: ${requestScope.abc}<br>
<c:set scope="request" var="abc" value="aabbcc"/>
after: ${requestScope.abc}<br>
<hr>
<%--
<c:if  /> if标签用来做if判断。
    test属性表示判断的条件（使用EL表达式输出）
--%>
<c:if test="${requestScope.abc eq 'aabbcc'}">
    after: ${requestScope.abc}<br>
</c:if>
<c:if test="${requestScope.abc ne 'aabbcc'}">
    after: not equal ${requestScope.abc}<br>
</c:if>
<hr>

<%--
<c:choose> <c:when> <c:otherwise> 标签
作用：多路判断。跟switch...case....default 非常接近
    choose 标签开始选择判断
    when标签表示每一种判断情况
        test属性表示当前这种判断情况的值
    otherwise  标签表示剩下的情况

 <c:choose> <c:when> <c:otherwise> 标签 使用时需要注意的点：
    1、标签里不能使用html注释，要使用jsp注释
    2、when标签的副标签一定要是choose标签
--%>
<c:set scope="request" var="height" value="170"/>
<c:choose>
    <c:when test="${requestScope.height > 190}">
        <h2>height &gt; 190</h2>
    </c:when>
    <c:when test="${requestScope.height > 180}">
        <h2>180 &lt; height &le; 190</h2>
    </c:when>
    <c:when test="${requestScope.height > 170}">
        <h2>170 &lt; height &le; 180</h2>
    </c:when>
    <c:otherwise>
        <h2> height &le; 170</h2>
    </c:otherwise>
</c:choose>

<%--
<c:foreach>  遍历1到10， 输出
begin属性设置开始的索引
end属性设置结束的索引
var属性表示遍历的变量

for(int i = 1; i<=10; i++){...}
--%>
<c:forEach begin="1" end="10" var="i">
    ${i}<br>
</c:forEach>
<hr>
<%--
<c:foreach>  遍历Object对象集合
items 表示遍历的数据源（遍历的集合）
var 表示当前遍历到的数据
begin属性设置开始的索引
end属性设置结束的索引
step 属性表示遍历的步长值
可以通过varstatus获取一系列当前for loop的一些信息，包括getIndex(), isFirst(), isLast(), getCount()....
for（Object o: arr){...}
--%>
<%
    request.setAttribute("arr", new String[]{"12132313","asadfasdff","12342dwfa"});
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "val1");
    map.put("key2", "val2");
    map.put("key3", "val3");
    map.put("key4", "val4");
    request.setAttribute("map",map);
%>
<c:forEach items="${requestScope.arr}" var="row">
    ${row} <br>
</c:forEach>
<hr>

<c:forEach items="${requestScope.map}" var="item">
    ${item.key} = ${item.value}<br>
</c:forEach>

<hr>

遍历List集合 --- list中存放student类，有属性：编号，用户名，密码，年龄，电话
<%--遍历List集合 --- list中存放student类，有属性：编号，用户名，密码，年龄，电话--%>
<%
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1,"a","A", 11,"111"));
    studentList.add(new Student(2,"b","B", 22,"222"));
    studentList.add(new Student(3,"c","C", 33,"333"));
    studentList.add(new Student(4,"d","D", 44,"444"));
    request.setAttribute("studentList", studentList);
%>
<%--可以通过varstatus获取一系列当前for loop的一些信息，包括getIndex(), isFirst(), isLast(), getCount()....--%>
<c:forEach items="${requestScope.studentList}" var="student" varstatus="status" step="2">
    Student: ${student}<br>
    Student: id:${student.id}, username: ${student.username}, password:${student.password}, age:${student.age}, phone:${student.phone}<br>
</c:forEach>

<table>
    <tr>
        <th>ID</th>
        <th>username</th>
        <th>password</th>
        <th>age</th>
        <th>phone</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.username}</td>
            <td>${student.password}</td>
            <td>${student.age}</td>
            <td>${student.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
