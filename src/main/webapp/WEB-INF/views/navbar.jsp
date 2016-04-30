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


    <c:set var="userId" value="1" />

    <s:url var="taskList" value="/task/list/${userId}" />
    <s:url var="home" value="/" />
    <s:url var="listaZadan" value="/listazadan" />
    <s:url var="addTask" value="/task/add" />
    <s:url var="taskDetail" value="/task/" />
    <s:url var="loginView" value="/login/" />

<nav class="navbar navbar-light bg-faded">
    <a class="navbar-brand" href="${home}">Task Manager</a>
    <ul class="nav navbar-nav" >
        <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${taskList}">Task List</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${listaZadan}">Lista Zadan</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${addTask}">Add Task</a>
        </li>
    </ul>
    <form class="form-inline pull-xs-right">
        <input class="form-control" type="text" placeholder="Search">
        <button class="btn btn-success-outline" type="submit">Search</button>
    </form>
    <ul class="nav navbar-nav navbar-right">
        <%--<li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li>--%>
        <li><a href="${loginView}">Logowanie</a></li>
    </ul>
</nav>



