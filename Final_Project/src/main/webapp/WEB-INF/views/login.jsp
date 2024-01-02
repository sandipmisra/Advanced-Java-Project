<%--
  Created by IntelliJ IDEA.
  User: apurbadebnath
  Date: 31/12/23
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>



<h2>Login</h2>



<form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="user">
    <label for="fullname">Username:</label>
    <form:input type="text" path="fullname" id="fullname" />
    <form:errors path="fullname" cssClass="error" />

    <br/>

    <label for="password">Password:</label>
    <form:input type="text" path="password" id="password" />
    <form:errors path="password" cssClass="error" />




    <br/>

    <input type="submit" value="Login"/>
</form:form>


</body>
</html>


