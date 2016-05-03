<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-30
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


    <c:set var="userId" value="1" />

    <s:url var="taskList" value="/task/list/${userId}" />
    <s:url var="home" value="/" />
    <s:url var="listaZadan" value="/listazadan" />
    <s:url var="addTask" value="/task/add" />
    <s:url var="taskDetail" value="/task/" />
    <s:url var="loginView" value="/login/" />
    <s:url var="loginView" value="/login" />
    <s:url var="employeeView" value="/employee/list" />
    <s:url var="profileView" value="/profile/" scope="application" />
<%--<link href='http://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css' rel="stylesheet"/>--%>

<nav class="navbar navbar-dark bg-inverse" style="margin-bottom: 30px">
    <a class="navbar-brand" href="${home}"><spring:message code="navbar_title"/></a>
    <ul class="nav navbar-nav" >
        <li class="nav-item active">
            <a class="nav-link" href="#"><spring:message code="navbar_home"/>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${taskList}"><spring:message code="navbar_task_list"/></a>
        </li>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="${listaZadan}"><spring:message code="navbar_all_task_assigned"/></a>--%>
        <%--</li>--%>
        <li class="nav-item">
            <a class="nav-link" href="${addTask}"><spring:message code="navbar_add_task"/></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${employeeView}"><spring:message code="navbar_employees_list"/></a>
        </li>
    </ul>
    <ul class="nav navbar-nav pull-xs-right">
            <sec:authorize  access="isAuthenticated()">
                <li class="nav-item" style="background-color: #1b6d85">
                    <sec:authentication property="principal.username" />
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/logout" />">
                        <spring:message code="navbar_logout"/>
                    </a>
                </li>
            </sec:authorize>
            <sec:authorize access="not isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${loginView}"><spring:message code="navbar_login"/></a>
                </li>
            </sec:authorize>
    </ul>
    <%--<form class="form-inline pull-xs-left">--%>
        <%--<input class="form-control" type="text" placeholder="Search">--%>
        <%--<button class="btn btn-success-outline" type="submit">Search</button>--%>
    <%--</form>--%>
</nav>


