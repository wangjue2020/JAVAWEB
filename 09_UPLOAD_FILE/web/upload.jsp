<%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-11
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/09_UPLOAD/uploadServlet" method="post" enctype="multipart/form-data">
        username: <input type="text" name="username"/><br>
        photo: <input type="file" name="photo"><br>
        <input type="submit" value="upload">
    </form>
</body>
</html>
