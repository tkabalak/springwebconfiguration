<%--
  Created by IntelliJ IDEA.
  User: Wiesiek
  Date: 2016-04-22
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fs" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/header.jsp" />

    <div id="login content">
        <fs:form action="${loginView}"  modelAttribute="user" method="post" cssClass="form-signin">
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputEmail" class="sr-only">Username</label>
            UserName: <fs:input id="inputEmail" path="username" type="text" cssClass="form-control" />
            <fs:errors path="username" />

            <label for="inputPassword" class="sr-only">Password</label>
            Password: <fs:input id="inputPassword" path="password" type="text" cssClass="form-control"/>
            <fs:errors path="password" />

            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </fs:form>
    </div>


<c:import url="/WEB-INF/views/footer.jsp" />