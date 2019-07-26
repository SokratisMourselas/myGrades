<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smoursel
  Date: 26-Jul-19
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Registration Form -->

<div id="loginbox" style="margin-top: 50px;"
     class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

    <div class="panel panel-info">

        <div class="panel-heading">
            <div class="panel-title">Register New User</div>
        </div>

        <div style="padding-top: 30px" class="panel-body">
            <form:form action="${pageContext.request.contextPath}/register/processRegistrationForm"
                       modelAttribute="crmUser"
                       class="form-horizontal">
                <!-- Check for registration error -->
                <c:if test="${registrationError != null}">
                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                            ${registrationError}
                    </div>
                </c:if>

                User name:  <form:input path="userName" placeholder="username" class="form-control" />

                Password: <form:password path="password" placeholder="password" class="form-control" />

                Confirm Password: <form:password path="matchingPassword" placeholder="password" class="form-control" />


                First Name: <form:input path="firstName" placeholder="first name" class="form-control" />
                <button type="submit" class="btn btn-primary">Register</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
