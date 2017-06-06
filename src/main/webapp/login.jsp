<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: suntrian
  Date: 17-6-6
  Time: 下午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%System.out.println(new Date().getTime()); %>
    <form action="/user/login" method="post">
        <input type="text" name="username" />
        <input type="password" name="password" />
        <input type="submit">
    </form>

</body>
</html>
