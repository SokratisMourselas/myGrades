<%--
  Created by IntelliJ IDEA.
  User: smoursel
  Date: 23-Jul-19
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Landing Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: rgba(255,250,212,0.36)">

<div>

    <div class="jumbotron text-center">
        <h1>Welcome to myGrades</h1>
        <p>myGrades is a database to keep all your academic records in one place.</p>
    </div>

    <div class="jumbotron text-center">
        <h2>
            <a href="${pageContext.request.contextPath}/general">Access Secure Site (requires login)</a>
        </h2>
    </div>


</div>
</body>
</html>
