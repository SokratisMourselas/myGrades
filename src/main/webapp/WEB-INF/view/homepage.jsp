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
</head>
<body>
<h2>Landing Page</h2>
<hr>
<p>
    Welcome to the landing page! This page is open to the public ... no login required :-)
</p>
<hr>
<p>
    <a href="${pageContext.request.contextPath}/general">Access Secure Site (requires login)</a>
</p>
</body>
</html>
