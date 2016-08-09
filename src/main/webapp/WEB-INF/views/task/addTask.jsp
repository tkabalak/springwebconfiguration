<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-30
  Time: 07:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:import url="/WEB-INF/views/header.jsp"/>

<spring:url value="employee/ajax" var="ajaxEmployee" />

<div class="container">
    <div class="content">
        <form:form method="post" modelAttribute="taskEntity" action="${addTask}">
            <div class="row">
                <h1><spring:message code="task_task_adding"/></h1>
                <div class='col-lg-6'>
                    <div class="form-group">
                        <spring:bind path="title">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-sm-2 control-label">Tytul</label>
                                <div class="col-sm-10">
                                    <form:input path="title"
                                                type="text"
                                                class="form-control "
                                                id="title"
                                                placeholder="title"/>
                                    <form:errors path="title" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>

                        <spring:bind path="description">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-sm-2 control-label">description</label>
                                <div class="col-sm-10">
                                    <form:textarea path="description"
                                                   type="text"
                                                   class="form-control "
                                                   id="description"
                                                   cssStyle="height: 40%;"
                                                   placeholder="description"/>
                                    <form:errors path="description" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>
                    </div>
                </div>
                <div class='col-lg-6'>
                    <div class="form-group">

                        <spring:bind path="deadline">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-md-2 control-label">deadline</label>
                                <div class="col-md-10">
                                    <fmt:formatDate value="" var="dateString" pattern="yyyy-mm-dd hh:mm:ss"/>
                                        <%--<form:input path="date" value="${dateString} .. />--%>
                                        <%--<input type="datetime-local" value="${dateString}" class="form-control date" name="deadline" id="deadline"/>--%>
                                    <form:input path="deadline"
                                                type="text"
                                                class="form-control date"
                                                id="deadline"
                                                placeholder="deadline"/>
                                    <form:errors path="deadline" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>

                        <spring:bind path="ownerId">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-md-2 control-label">owner</label>
                                <div class="col-md-10">
                                    <form:input path="ownerId"
                                                type="text"
                                                class="form-control date"
                                                id="ownerId"
                                                placeholder="ownerId"/>
                                    <form:errors path="ownerId" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>
                    </div>
                </div>
            </div>

            <div class="row">
                <p></p>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-4">
                    <button type="submit" class="btn btn-success">
                        <spring:message code="task_button_add_task"/>
                    </button>
                </div>
            </div>
        </form:form>
    </div>
</div>
<script type="text/javascript">

    $(document).ready(function() {
        $('#deadline').datepicker();

        $("#ownerId").keyup(function () {
            var emplName = $("#ownerId").val();
            $.ajax({
                url: '${ajaxEmployee}',
                method : 'GET',
                dataType: 'text',
                data : {'search' : emplName},
                success : function (response) {
                    console.log('test');
                    $("#ownerId").autocomplete({
                        source: $.map($.parseJSON(response), function(item) {
                            return { label: item.name, value: item.id };
                        })
                    });
                },
                error : function (err) {
                    console.log(err);
                }
            });
        });
    });

</script>

<c:import url="/WEB-INF/views/footer.jsp"/>