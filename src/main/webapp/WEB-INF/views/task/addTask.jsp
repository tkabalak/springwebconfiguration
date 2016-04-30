<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-30
  Time: 07:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Dodawanie zadania</title>
</head>
<body>
    <c:import url="/WEB-INF/views/navbar.jsp" />



    <form:form method="post" modelAttribute="taskEntity" action="${addTask}">
        <form:input path="title" type="text" /> <!-- bind to user.name-->
        <form:errors path="title" />

        <form:input path="description" type="text" />
        <form:errors path="description" />

        <form:input path="ownerId" type="text" />
        <form:errors path="ownerId" />

        <form:button value="submit" >Dodaj</form:button>

    </form:form>
</body>
</html>
