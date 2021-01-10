<%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-09
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    <%@ include file="./header.jsp"%> 就是静态包含
    file属性指定你要包含的jsp页面的路径
    地址中的斜杠/表示为http：//IP：port/工程路径/ 映射到代码的web目录
    静态包含的特点：
    1、静态包含不会翻译被包含的jsp页面。
    2、静态包含其实是把被包含的jsp页面的代码拷贝到包含的位置执行输出
--%>
<%@ include file="./header.jsp"%>

main body<br>
<%--
    <jsp:include page="./footer.jsp"></jsp:include> 就是动态包含
    page 属性指定你要包含的jsp页面的路径
    动态包含也可以像静态包含一样，把被包含的内容执行输出到包含的位置

    动态包含的特点：
    1、动太包含会把包含的jsp页面也翻译成java代码
    2、动态包含底层代码使用如下代码去调用被包含的jsp页面执行输出。
        JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);
    3、动态包含，还可以传递参数
--%>
<jsp:include page="./footer.jsp">
    <jsp:param name="username" value="bbj"/>
    <jsp:param name="password" value="a"/>
</jsp:include>

</body>
</html>
