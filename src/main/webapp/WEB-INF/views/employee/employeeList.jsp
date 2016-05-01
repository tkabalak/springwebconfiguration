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

<c:import url="/WEB-INF/views/header.jsp" />

<table class="table" style="margin-top: 30px;">
    <thead class="thead-inverse">
    <tr>
        <th>#</th>
        <th><spring:message code="employee_id_hash"/></th>
        <th><spring:message code="employee_name"/></th>
        <th><spring:message code="emppoyee_surname"/></th>
        <th><spring:message code="employee_email"/></th>
        <th><spring:message code="employee_phone"/></th>
        <th><spring:message code="employee_manager_name"/></th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="employee" items="${employees}" >
            <tr>
                <th scope="row">
                    <a href="${profileView}${employee.idEmployee}">${employee.idEmployee}</a>
                </th>
                <td>
                    <a href="${profileView}${employee.idEmployee}">${employee.name}</a>
                </td>
                <td>
                    ${employee.surname}
                </td>
                <td>
                    ${employee.email}
                </td>
                <td>
                    ${employee.phone}
                </td>
                <td>
                    ${employee.managerId}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<c:import url="/WEB-INF/views/footer.jsp" />