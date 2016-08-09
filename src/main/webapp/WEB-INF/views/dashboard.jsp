<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-29
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:import url="/WEB-INF/views/navbar.jsp" />

<div class="container">
    <c:forEach items="${zadania}" var="zadanie">
        <tr>
            <td>${zadanie.title}</td>
            <td>${zadanie.description}</td>
        </tr>
    </c:forEach>
</div>

<c:import url="/WEB-INF/views/footer.jsp" />