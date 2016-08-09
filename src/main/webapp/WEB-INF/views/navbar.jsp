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
    <s:url var="myTaskList" value="/task/my" />
    <s:url var="home" value="/" />
    <s:url var="listaZadan" value="/listazadan" />
    <s:url var="addTask" value="/task/add" />
    <s:url var="taskDetail" value="/task/" />
    <s:url var="loginView" value="/login/" />
    <s:url var="loginView" value="/login" />
    <s:url var="employeeView" value="/employee/list" />
    <s:url var="employeeAddView" value="/employee/add" />
    <s:url var="profileView" value="/profile/" scope="application" />
    <s:url value="/search/contact" var="searchURL"/>

<%--<link href='http://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css' rel="stylesheet"/>--%>

<nav class="navbar navbar-dark bg-inverse" style="margin-bottom: 30px">
    <div class="container">
    <a class="navbar-brand" href="${home}"><spring:message code="navbar_title"/></a>
    <ul class="nav navbar-nav" >
        <li class="nav-item active">
            <a class="nav-link" href="#"><spring:message code="navbar_home"/>
            </a>
        </li>
        <sec:authorize  access="hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
            <li class="nav-item">
                <a class="nav-link" href="${myTaskList}"><spring:message code="navbar_task_list"/></a>
            </li>
        </sec:authorize>
        <sec:authorize  access="hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')">
            <li class="nav-item">
                <a class="nav-link" href="${addTask}"><spring:message code="navbar_add_task"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${employeeView}"><spring:message code="navbar_employees_list"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${employeeAddView}"><spring:message code="navbar_employees_add_person"/></a>
            </li>
        </sec:authorize>
        <sec:authorize  access="hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
            <li class="nav-item">
                <a class="nav-link" href="${searchURL}"><spring:message code="search_search_btn"/></a>
            </li>
        </sec:authorize>
    </ul>
    <ul class="nav navbar-nav pull-xs-right">
            <sec:authorize  access="isAuthenticated()">
                <li class="nav-item">
                    <c:set var="username"><sec:authentication property="principal.login.employeeId.name" /></c:set>
                    <c:set var="usersurname"><sec:authentication property="principal.login.employeeId.surname" /></c:set>
                    <c:set var="userid"><sec:authentication property="principal.login.employeeId.idEmployee" /></c:set>
                    <s:url value="/profile/${userid}" var="userProfileUrl" />
                    <a href="${userProfileUrl}" class="nav-link text-danger">
                        ${username} ${usersurname}
                    </a>
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

        <%--<div class="container">
            <form class="searchbox">
                <input type="search" placeholder="Search......" name="search" class="searchbox-input" onkeyup="buttonUp();" required>
                <input type="submit" class="searchbox-submit" value="GO">
                <span class="searchbox-icon">GO</span>
            </form>
        </div>--%>
    </div>
</nav>

<script>
    $(document).ready(function(){
        var submitIcon = $('.searchbox-icon');
        var inputBox = $('.searchbox-input');
        var searchBox = $('.searchbox');
        var isOpen = false;
        submitIcon.click(function(){
            if(isOpen == false){
                searchBox.addClass('searchbox-open');
                inputBox.focus();
                isOpen = true;
            } else {
                searchBox.removeClass('searchbox-open');
                inputBox.focusout();
                isOpen = false;
            }
        });
        submitIcon.mouseup(function(){
            return false;
        });
        searchBox.mouseup(function(){
            return false;
        });
        $(document).mouseup(function(){
            if(isOpen == true){
                $('.searchbox-icon').css('display','block');
                submitIcon.click();
            }
        });
    });
    function buttonUp(){
        var inputVal = $('.searchbox-input').val();
        inputVal = $.trim(inputVal).length;
        if( inputVal !== 0){
            $('.searchbox-icon').css('display','none');
        } else {
            $('.searchbox-input').val('');
            $('.searchbox-icon').css('display','block');
        }
    }
</script>
