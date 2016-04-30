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
        <fs:form action="${loginView}"  modelAttribute="user" method="post">
            UserName: <fs:input path="username" type="text"/>
            <fs:errors path="username" />
            Password: <fs:password path="password"  />
        </fs:form>
    </div>

</body>
</html>
