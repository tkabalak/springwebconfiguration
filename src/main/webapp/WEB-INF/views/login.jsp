<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-22
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fs" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:import url="/WEB-INF/views/header.jsp" />
<div class="container">
    <div id="login content">
        <fs:form action="${loginView}"  modelAttribute="user" method="POST" cssClass="form-signin">
            <h2 class="form-signin-heading"><spring:message code="login_please_sign_in"/></h2>
            <label for="inputEmail" class="sr-only"><spring:message code="navbar_home"/></label>
                <spring:message code="login_username"/>
                <fs:input id="inputEmail" path="username" type="text" cssClass="form-control" />
            <fs:errors path="username" />

            <label for="inputPassword" class="sr-only"><spring:message code="login_password"/></label>
                <spring:message code="login_password"/>
                <fs:input id="inputPassword" path="password" type="text" cssClass="form-control"/>
            <fs:errors path="password" />

            <div class="checkbox">
                <label>
                    <input id="remember_me" name="remember-me" type="checkbox" value="remember-me">
                    <spring:message code="login_remember_me"/>
                </label>
            </div>

            <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="login_sign_in"/></button>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </fs:form>
    </div>

    <%--<form action="/logout" method="post">--%>
        <%--<input type="submit" class="button red big" value="Sign in as different user" /> <input--%>
            <%--type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    <%--</form>--%>
</div>

<c:import url="/WEB-INF/views/footer.jsp" />