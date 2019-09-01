<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: smoursel
  Date: 23-Jul-19
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Appointments Page</title>
</head>
<body>
<h2>myGrades Appointment Portal</h2>
<hr>

<h3>Book a new appointment</h3>

<!-- Roles -->
<div style="margin-bottom: 25px">
    <form:form action="${pageContext.request.contextPath}/register/newAppointmentForm"
               modelAttribute="newAppointment"
    >
        Available Dates and Times: <form:select path="dateAndTime" items="${datesAndTimes}"/>
    </form:form>
</div>

<a href="${pageContext.request.contextPath}/general">Go back to Home Page</a>

</body>
</html>
