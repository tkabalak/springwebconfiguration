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

<div class="container">
    <div class="row">

        <div class="col-md-6">
            <h1><spring:message code="user_datails"/></h1>
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
                <label class="col-sm-2"><spring:message code="employee_name"/></label>
                <div class="col-sm-10">
                    <a href="${profileView}${employee.idEmployee}">${employee.fullName}</a>
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="employee_email"/></label>
                <div class="col-sm-10">${employee.email}</div>
            </div>
            <div class="row">
                <label class="col-sm-2">
                    <spring:message code="employee_phone"/>
                </label>
                <div class="col-sm-10">
                    ${employee.phone}
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="employee_manager_name"/></label>
                <div class="col-sm-10">
                    <spring:url value="/profile/${employee.manager.idEmployee}" var="managerProfileURL"/>
                    <a href="${managerProfileURL}">
                        ${employee.manager.name} ${employee.manager.surname}
                    </a>
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2">
                    <spring:message code="employee_pesel"/>
                </label>
                <div class="col-sm-10">
                    ${employee.pesel}
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2">
                    <spring:message code="employe_start_working"/>
                </label>
                <div class="col-sm-10">
                    ${employee.addedDate}
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <spring:url value="/task/list/${employee.idEmployee}" var="taskListUrl" />
                    <a href="${taskListUrl}" ><spring:message code="navbar_task_list"/></a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <h1><spring:message code="address_details"/></h1>
            <br />
            <div class="row">
                <label class="col-sm-2"><spring:message code="city"/></label>
                <div class="col-sm-10">
                    ${employee.address.cityName}
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="street"/></label>
                <div class="col-sm-10">
                    ${employee.address.street}
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="postal_code"/></label>
                <div class="col-sm-10">
                    ${employee.address.postalCode}
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2"><spring:message code="city"/></label>
                <div class="col-sm-10">
                    ${employee.address.houseNum}
                </div>
            </div>

        </div>
    </div>
</div>

<c:import url="/WEB-INF/views/footer.jsp" />