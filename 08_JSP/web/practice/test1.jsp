<%--
  Created by IntelliJ IDEA.
  User: Wangjue
  Date: 2021-01-09
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--在jsp页面中输出九九乘法口诀表--%>
    <table border="1">
    <%
        for( int i = 1; i <= 9; i++){
    %>
            <tr>
                <%
                    for(int j = i; j <= 9; j++){
                %>
                        <td>
                            <%=i%> * <%=j%> = <%= i*j%>
                        </td>
                <%
                    }
                %>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
