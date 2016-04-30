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

<html>
    <c:set var="userId" value="1" />

    <s:url var="taskList" value="/task/list/${userId}" />
    <s:url var="home" value="/" />
    <s:url var="listaZadan" value="/listazadan" />
    <s:url var="addTask" value="/task/add" />

    <a href="${home}">Home</a>
    <a href="${taskList}">Tasks</a>
    <a href="${listaZadan}">Lista Zadan</a>
    <a href="${addTask}">Dodaj zadanie</a>

    <br />
</html>
