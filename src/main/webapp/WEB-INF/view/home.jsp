<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  Person: smoursel
  Date: 22-Jul-19
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        body {
            position: relative;
        }
        #section1 {padding-top:70px;height:500px;color: #000; background-color: rgba(137, 200, 229, 0.76);}
        #section2 {padding-top:50px;height:500px;color: #fff; background-color: rgb(147, 42, 58);}
        #section3 {padding-top:50px;height:500px;color: #000; background-color: rgba(159, 135, 28, 0.54);}
        #section41 {padding-top:50px;height:500px;color: #fff; background-color: rgba(14, 0, 150, 0.75);}
        #section42 {padding-top:50px;height:500px;color: #fff; background-color: #7b9596;}
    </style>
</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/general">myGrades</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/general">Home</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Classes<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">5th Junior</a></li>
                            <li><a href="#">6th Junior</a></li>
                            <li><a href="#">1st Senior<span> (Active) </span></a> </li>
                        </ul>
                    </li>
                    <li><a href="#">Current Lessons</a></li>
                    <li><a href="#">Projects</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span><security:authentication property="principal.username"/></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">View Profile</a></li>
                            <li><a href="#">Security</a></li>
                            <li><a href="#">Settings</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-log-out"></span>Logout</a>
                        <ul class="dropdown-menu">
                            <li><i style="text-align: center">Are you sure?</i></li>
                            <li><a href="" onclick="$('#myHiddenFormId').submit(); return false;">Yes</a></li>
                            <li><a href="#">No</a></li>
                        </ul>
                    </li>
                </ul>
                <form:form id="myHiddenFormId" action="${pageContext.request.contextPath}/logout"
                           method="POST" style="display: none">
                </form:form>
            </div>
        </div>
    </nav>


    <div id="section1" class="container-fluid">
        <h1>Welcome to your personal myGrades Account</h1>
        <p>Security is our first concern and we update this website regularly to ensure you are always safe.</p>
        <p>If at any point you encounter any issue, please <a href="#">contact our team</a> immediately.</p>
    </div>
    <div id="section2" class="container-fluid">
        <h1>Your Classes</h1>
        <p>You have been registered to the following classes in the past:</p><br>
        <div class="container">
            <h2>Complete history:</h2>
            <div class="list-group">
                <a href="#" class="list-group-item">5th Junior</a>
                <a href="#" class="list-group-item">6th Junior</a>
                <a href="#" class="list-group-item">1st Senior <span> (Currently enrolled) </span> </a>
            </div>
        </div>
    </div>
    <div id="section3" class="container-fluid">
        <h1>Section 3</h1>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
    </div>
    <div id="section41" class="container-fluid">
        <h1>Section 4 Submenu 1</h1>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
    </div>
    <div id="section42" class="container-fluid">
        <h1>Section 4 Submenu 2</h1>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
    </div>


    <footer class="footer">
        <security:authentication property="principal.authorities"/>
        <security:authorize access="hasRole('STUDENT')">
            <p><a href="${pageContext.request.contextPath}/students">Proceed as a Student</a></p>
        </security:authorize>
        <security:authorize access="hasRole('TEACHER')">
            <p><a href="${pageContext.request.contextPath}/teachers">Proceed as a Teacher</a></p>
        </security:authorize>
    </footer>

</body>
</html>
