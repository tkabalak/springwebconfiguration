<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-30
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:import url="/WEB-INF/views/header.jsp" />
<div class="container">
    <div class="row">

        <div class="col-md-6">
            <h1>Task Detail</h1>
            <br />
            <c:if test="${not empty msg}">
                <div class="alert alert-${css} alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>${msg}</strong>
                </div>
            </c:if>



            <div class="row">
                <label class="col-sm-2">ID</label>
                <div class="col-sm-10">
                    <a href="/task/${zadanie.idTask}">${zadanie.idTask}</a>
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="task_name"/></label>
                <div class="col-sm-10">${zadanie.title}</div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="added_date"/></label>
                <div class="col-sm-10">${zadanie.addedDate}</div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="task_status_title"/></label>
                <div class="col-sm-10"><spring:message code="task_stat_${zadanie.status}"/></div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="task_deadline"/></label>
                <div class="col-sm-10">${zadanie.deadline}</div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="employee_manager_name"/></label>
                <div class="col-sm-10">
                    <a href="${profileView}${zadanie.managerId.idEmployee}" >
                        ${zadanie.managerId.fullName}
                    </a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="row">
                <form:form method="post" modelAttribute="progress" action="/progress/add">
                    <div class="form-group">
                        <div class="col-md-push-2" >
                        <label for="description">Comment:</label>
                        <spring:bind path="description">
                            <div class="form-group ${status.error ? 'has-error' : ''}" style="margin-bottom: 20px">
                                <div class="col-sm-12">
                                    <form:textarea rows="5" path="description"
                                                    type="text"
                                                    class="form-control "
                                                    id="description"
                                                placeholder="description"/>
                                    <form:errors path="description" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>
                        </div>
                        <spring:bind path="spendHours">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <div class="col-sm-3">
                                    <form:input   path="spendHours"
                                                    type="number"
                                                    class="form-control "
                                                    id="spendHours"
                                                   placeholder="spend hours"/>
                                    <form:errors path="spendHours" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>
                        <spring:bind path="performed">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <div class="col-sm-3">
                                    <form:input   path="performed"
                                                    type="number"
                                                    class="form-control "
                                                    id="performed"
                                                   placeholder="performed"/>
                                    <form:errors path="performed" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>
                        <spring:bind path="addedDate">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <div class="col-md-3">
                                    <form:input path="addedDate"
                                                type="text"
                                                class="form-control date"
                                                id="addedDate"
                                                placeholder="addedDate"/>
                                    <form:errors path="addedDate" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>
                            <div class="col-md-3">
                                <button type="submit" class="btn btn-success">
                                    <spring:message code="task_button_add_task"/>
                                </button>
                            </div>
                        <input type="hidden" name="idTask" value="${zadanie.idTask}"/>
                    </div>
                </form:form>
                <div class="row">
                    <label class="col-sm-2"></label>
                    <div class="col-sm-10"></div>
                </div><div class="row">
                    <label class="col-sm-2"></label>
                    <div class="col-sm-10"></div>
                </div><div class="row">
                    <label class="col-sm-2"></label>
                    <div class="col-sm-10"></div>
                </div>
                <div class="row">
                    <div class="col-sm-3 col-sm-offset-9">
                        <spring:url value="/task/done/${zadanie.idTask}" var="doneBtn"/>
                        <a href="${doneBtn}" class="btn btn-success" >
                            Done
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${not empty zadanie.progress}" >
    <div class="row">
        <table class="table" style="margin-top: 30px;">
            <thead class="thead-inverse" style="overflow: auto;">
            <tr>
                <th>#</th>
                <th><spring:message code="added_date"/></th>
                <th><spring:message code="description"/></th>
                <th><spring:message code="spend_hours"/></th>
                <th><spring:message code="performed"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${zadanie.progress}" var="progressItem" varStatus="i">
                <tr>
                    <th scope="row">
                        ${i.index + 1}
                    </th>
                    <td>
                        ${progressItem.addedDate}
                    </td>
                    <td>
                        ${progressItem.description}
                    </td>
                    <td>
                        ${progressItem.spendHours}
                    </td>
                    <td>
                        ${progressItem.performed}
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </c:if>
</div>
<script type="text/javascript">

    $(document).ready(function() {
        $('#addedDate').datepicker({
            dateFormat: 'yy-mm-dd',
        });
    });

</script>
<c:import url="/WEB-INF/views/footer.jsp" />
