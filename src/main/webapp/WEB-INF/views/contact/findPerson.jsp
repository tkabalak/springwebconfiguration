<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-05-01
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/views/header.jsp"/>
<div class="container">
    <spring:url value="/search/contact" var="searchURL"/>
    <div class="row">
        <form:form method="post" modelAttribute="src"  action="${searchURL}">
            <div class='col-md-9'>
                    <spring:bind path="search">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-md-2 col-md-offset-2 control-label text-center">Wyszukiwanie pracownika</label>
                            <div class="col-md-8">
                                <form:input path="search"
                                            type="text"
                                            class="form-control"
                                            id="search"
                                            placeholder="imie nazwisko"/>
                                <form:errors path="search" class="control-label"/>
                            </div>
                        </div>
                    </spring:bind>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                        <button type="submit" class="btn btn-success">
                            <spring:message code="search_search_btn"/>
                        </button>
                </div>
            </div>
        </form:form>
    </div>

    <c:if test="${not empty employees}">
        <table class="table" style="margin-top: 30px;">
            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th><spring:message code="employee_name"/></th>
                <th><spring:message code="employee_email"/></th>
                <th><spring:message code="employee_phone"/></th>
                <th><spring:message code="employee_manager_name"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <th scope="row">
                        <a href="${profileView}${employee.idEmployee}">${employee.idEmployee}</a>
                    </th>
                    <td>
                        <a href="${profileView}${employee.idEmployee}">${employee.name} ${employee.surname}</a>
                    </td>
                    <td>
                            ${employee.email}
                    </td>
                    <td>
                            ${employee.phone}
                    </td>
                    <td>
                        <c:set value="${employee.manager}" var="manager"/>
                        <c:set var="managerName">${manager.name} ${manager.surname}</c:set>
                        <spring:url value="/profile/${manager.idEmployee}" var="managerProfileUrl"/>
                        <a href="${managerProfileUrl}"><span class="text">${managerName}</span></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

<c:import url="/WEB-INF/views/footer.jsp"/>