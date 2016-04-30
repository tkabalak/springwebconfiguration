<%-- 
    Document   : index
    Created on : 2015-11-12, 11:26:13
    Author     : Wiesiek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="/WEB-INF/views/navbar.jsp" />
        <spring:message code="elo"/>
        <a href="/listazadan"> lista zadan </a>

        <h1>Hello World!</h1>
    </body>
</html>
