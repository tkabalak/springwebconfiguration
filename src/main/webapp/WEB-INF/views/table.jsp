<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-03-09
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/header.jsp" />

    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${zadania}" var="zadanie">
                <tr>
                    <td>${zadanie.name}</td>
                    <td>${zadanie.title}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
