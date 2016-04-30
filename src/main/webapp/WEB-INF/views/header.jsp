<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-30
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Task Details</title>
    <script src="<c:url value="/files/angular/angular.js" />" ></script>
    <s:url value="/files/bootstrap/css/bootstrap.css" var="bootstrapUrl" />
    <link href='${bootstrapUrl}' rel="stylesheet"/>
</head>
<body>

<c:import url="/WEB-INF/views/navbar.jsp" />