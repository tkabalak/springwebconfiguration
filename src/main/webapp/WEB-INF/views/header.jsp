<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-30
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="charset=UTF-8">

    <title>Task Details</title>
    <%--<script src="<c:url value="/files/angular/angular.js" />" ></script>--%>


    <s:url value="/files/jquery/moment.min.js" var="momentJsUrl" />
    <script src="${momentJsUrl}"><jsp:text /></script>


    <s:url value="/files/jquery/jquery.js" var="jqueryUrl" />
    <script src="${jqueryUrl}"><jsp:text /></script>

    <%--<s:url value="/files/jquery/jquery-ui.js" var="jqueryUIUrl" />--%>
    <%--<script src="${jqueryUIUrl}"></script>--%>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

    <%--<s:url value="/files/jquery/bootstrap-datetimepicker.min.js" var="bootstrapDatapickerUrl" />--%>
    <%--<script src="${bootstrapDatapickerUrl}"><jsp:text /></script>--%>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <s:url value="/files/bootstrap/css/bootstrap.css" var="bootstrapUrl" />
    <s:url value="/files/styles/signin.css" var="signInUrl" />
    <%--<link href='${bootstrapUrl}' rel="stylesheet"/>--%>
    <link href='http://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css' rel="stylesheet"/>
    <link href='${signInUrl}' rel="stylesheet"/>


</head>
<body>

<c:import url="/WEB-INF/views/navbar.jsp" />