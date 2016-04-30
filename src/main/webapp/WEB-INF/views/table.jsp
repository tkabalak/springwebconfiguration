<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-03-09
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Content</title>
    <link type="text/css" rel="stylesheet" href="C:\Users\Wiesiek\Desktop\WEB\files\bootstrap\css\bootstrap.css">
</head>
<body>
    <c:import url="/WEB-INF/views/navbar.jsp" />
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${zadania}" var="zadanie">
                <tr>
                    <td>${zadanie.name}</td>
                    <td>${zadanie.title}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
