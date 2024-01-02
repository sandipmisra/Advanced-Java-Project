<%--
  Created by IntelliJ IDEA.
  User: apurbadebnath
  Date: 26/12/23
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Edit Buyer Profile</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    h3 {
      color: #007bff;
    }

    form {
      margin-top: 20px;
    }

    label {
      display: block;
      margin-bottom: 5px;
    }

    input,
    select {
      margin-bottom: 10px;
    }

    .error-message {
      color: red;
      margin-top: 5px;
    }

    input[type="submit"] {
      background-color: #007bff;
      color: #fff;
      padding: 8px 15px;
      cursor: pointer;
    }
    button[type="button"] {
      background-color: #007bff;
      color: #fff;
      padding: 8px 15px;
      cursor: pointer;
    }
    a {
      margin-top: 10px;
      display: block;
      text-decoration: none;
      color: #007bff;
    }
  </style>
</head>
<body>

<h2>Edit Buyer Profile</h2>
<h2>Welcome to the Dream House, ${authenticatedUser.fullname}!</h2>

<form:form method="post" action="${pageContext.request.contextPath}/updateUser/${user.id}" modelAttribute="user">

  <fieldset>
    <legend>User Information</legend>

    <label for="fullname">Full Name:</label>
    <form:input path="fullname" id="fullname" value="${user.fullname}" />
    <form:errors path="fullname" cssClass="error" />

    <br>

    <label>Gender:</label>
    <form:radiobutton path="gender" value="MALE" label="MALE"/>
    <form:radiobutton path="gender" value="FEMALE" label="FEMALE"/>
    <form:errors path="gender" cssClass="error" />

    <br>

    <label>Date Of Birth:</label>
    <form:input type="date" path="dateOfBirth" id="dateOfBirth" />
    <form:errors path="dateOfBirth" cssClass="error" />

    <br>

    <label>Email:</label>
    <form:input path="email" id="email" />
    <form:errors path="email" cssClass="error" />

    <br>

    <label>Password:</label>
    <form:input path="password" id="password" />
    <form:errors path="password" cssClass="error" />

    <br>

    <%--<label>Quota:</label>
    <input type="checkbox" name="quotaCheckbox" id="quotaCheckbox"
           <c:if test="${user.quota == 'Yes'}">checked</c:if> />

    <br>

    <label for="country">Country:</label>
    <select name="country" id="country">
      <option value="Bangladesh" <c:if test="${user.country == 'Bangladesh'}">selected</c:if>>Bangladesh</option>
      <option value="Afghanistan" <c:if test="${user.country == 'Afghanistan'}">selected</c:if>>Afghanistan</option>
      <option value="China"<c:if test="${user.country == 'China'}"> selected</c:if>>China</option>
      <option value="India"<c:if test="${user.country == 'India'}"> selected</c:if>>India</option>
      <option value="Indonesia"<c:if test="${user.country == 'Indonesia'}"> selected</c:if>>Indonesia</option>
      <option value="Japan"<c:if test="${user.country == 'Japan'}"> selected</c:if>>Japan</option>
      <option value="South Korea"<c:if test="${user.country == 'South Korea'}"> selected</c:if>>South Korea</option>
      <option value="Malaysia"<c:if test="${user.country == 'Malaysia'}"> selected</c:if>>Malaysia</option>
      <option value="Thailand"<c:if test="${user.country == 'Thailand'}"> selected</c:if>>Thailand</option>
      <option value="Vietnam"<c:if test="${user.country == 'Vietnam'}"> selected</c:if>>Vietnam</option>

    </select>--%>

  </fieldset>

  <br>

  <input type="submit" value="Update" />
  <a href="${pageContext.request.contextPath}/dashboard">
    <button type="button">Cancel Update</button></a>

</form:form>
</body>
</html>


