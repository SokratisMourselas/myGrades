<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: smoursel
  Date: 22-Jul-19
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

    <h2>Home Page</h2>
<hr>
<h3>Welcome to the app</h3>

    <p>
    User: <security:authentication property="principal.username"/><br>
    Role(s): <security:authentication property="principal.authorities"/>
    </p><br>

    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">
        <input type="submit" value="Logout"/>
    </form:form>


</body>
</html>
