<%--
  Created by IntelliJ IDEA.
  User: suntr
  Date: 5/18/2017
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>articles list</title>
</head>
<body>
    <c:forEach items="${articles}" var="item">
        ${item.id }--${item.title }--${item.content }<br />
    </c:forEach>
</body>
</html>
