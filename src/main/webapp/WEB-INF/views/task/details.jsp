<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-30
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/header.jsp" />

        <tr>
            <td><a href="/task/${zadanie.idTask}">${zadanie.idTask}</a></td>
            <td>${zadanie.title}</td>
            <td>${zadanie.addedDate}</td>
            <td>${zadanie.status}</td>
            <td>${zadanie.deadline}</td>
        </tr>

<c:import url="/WEB-INF/views/footer.jsp" />
