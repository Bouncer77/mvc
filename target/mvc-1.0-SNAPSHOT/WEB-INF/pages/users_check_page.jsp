<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Bouncer77
  Date: 02.11.2021
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <spring:form modelAttribute="userFromServer" method="post" action="/user-system/users/check">
        <spring:input path="login"/>
        <spring:input path="password"/>
        <spring:button>Validate User</spring:button>
    </spring:form>
</body>
</html>
