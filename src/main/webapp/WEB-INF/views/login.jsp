<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-22
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fs" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>
    <div id="login content">
        <fs:form action="login" method="post">
            UserName: <fs:input path="username" />
            Password: <fs:password path="password" />
        </fs:form>
    </div>

</body>
</html>
