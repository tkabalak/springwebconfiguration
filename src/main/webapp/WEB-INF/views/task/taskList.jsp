<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-29
  Time: 23:26
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
        <th><spring:message code="task_name"/></th>
        <th><spring:message code="task_data_dodania"/></th>
        <th><spring:message code="task_status_title"/></th>
        <th><spring:message code="task_deadline"/></th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${zadania}" var="zadanie">
            <tr>
                <th scope="row">
                    <a href="/task/${zadanie.idTask}">${zadanie.idTask}</a>
                </th>
                <td>
                    <a href="/task/${zadanie.idTask}">${zadanie.title}</a>
                </td>
                <td>
                    <fmt:formatDate value="${zadanie.addedDate}" pattern="dd.MM.yyy hh:mm"/>
                </td>
                <td>
                    <spring:message code="task_stat_${zadanie.status}"/>
                </td>
                <td>
                    <fmt:formatDate value="${zadanie.deadline}" pattern="dd.MM.yyy hh:mm"/>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<c:import url="/WEB-INF/views/footer.jsp" />