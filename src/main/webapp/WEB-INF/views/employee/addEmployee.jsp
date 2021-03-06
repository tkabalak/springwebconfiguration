<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-05-01
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>

<c:import url="/WEB-INF/views/header.jsp" />

<div class="container">
    <div class="content">
        <form:form method="post"
                   modelAttribute="employee"
                   action="${employeeAddView}"
                   class="form-horizontal">
            <div class="row">
                <div class="col-lg-6">
                    <h1>Dane osobowe</h1>
                        <spring:bind path="name">
                        <div class="form-group box ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Name</label>
                            <div class="col-sm-10">
                                <form:input path="name" type="text" class="form-control " id="name" placeholder="Name" />
                                <form:errors path="name" class="control-label" />
                            </div>
                        </div>
                        </spring:bind>

                        <spring:bind path="email">
                        <div class="form-group box ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <form:input path="email" class="form-control" id="email" placeholder="Email" />
                                <form:errors path="email" class="control-label" />
                            </div>
                        </div>
                        </spring:bind>

                        <spring:bind path="surname">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Surname</label>
                            <div class="col-sm-10">
                                <form:input path="surname" class="form-control" id="surname" placeholder="surnme" />
                                <form:errors path="surname" class="control-label" />
                            </div>
                        </div>
                        </spring:bind>


                        <%--<select name="positionStat">--%>
                            <%--<option value="0">ADMIN</option>>--%>
                            <%--<option value="1">DBA</option>>--%>
                            <%--<option value="2">USER</option>>--%>
                        <%--</select>--%>
                        <%--<form:errors path="positionStat" />--%>



                </div>
                <div class="col-lg-6">

                    <h1>Adres</h1>
                    <spring:bind path="address.cityName">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-3 control-label">
                                Miasto
                            </label>
                            <div class="col-sm-9">
                                <form:input path="address.cityName"
                                            type="text"
                                            class="form-control "
                                            id="cityName"
                                            placeholder="Name" />
                                <form:errors path="address.cityName"
                                             class="control-label" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="address.street">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-3 control-label">
                                Ulica
                            </label>
                            <div class="col-sm-9">
                                <form:input path="address.street"
                                            type="text"
                                            class="form-control "
                                            id="street"
                                            placeholder="Name" />
                                <form:errors path="address.street"
                                             class="control-label" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="address.houseNum">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-3 control-label">
                                Numer domu
                            </label>
                            <div class="col-sm-9">
                                <form:input path="address.houseNum"
                                            type="text"
                                            class="form-control "
                                            id="houseNum"
                                            placeholder="Name" />
                                <form:errors path="address.houseNum"
                                             class="control-label" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="address.postalCode">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-3 control-label">
                                Kod pocztowy
                            </label>
                            <div class="col-sm-9">
                                <form:input path="address.postalCode"
                                            type="text"
                                            class="form-control "
                                            id="postalCode"
                                            placeholder="Name" />
                                <form:errors path="address.postalCode"
                                             class="control-label" />
                            </div>
                        </div>
                    </spring:bind>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-4">
                    <button type="submit" class="btn btn-success">
                        <sp:message code="navbar_employees_add_person" />
                    </button>
                </div>
            </div>
        </form:form>
    </div>
</div>

<c:import url="/WEB-INF/views/footer.jsp" />