<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-30
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:import url="/WEB-INF/views/header.jsp" />
     <table class="table">
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
            <tr>
                <td><a href="/task/${zadanie.idTask}">${zadanie.idTask}</a></td>
                <td>${zadanie.title}</td>
                <td>${zadanie.addedDate}</td>
                <td>${zadanie.status}</td>
                <td>${zadanie.deadline}</td>
                <td>
                    <a href="${profileView}${manager.managerId}" >
                        ${manager.fullName}
                    </a>
                </td>

            </tr>
         </tbody>
    </table>
<c:import url="/WEB-INF/views/footer.jsp" />
