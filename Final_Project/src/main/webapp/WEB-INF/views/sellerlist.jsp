<%--
  Created by IntelliJ IDEA.
  User: apurbadebnath
  Date: 1/1/24
  Time: 8:11 AM
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
    <title>For Sale Apartment Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            color: #007bff;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 8px 15px;
            cursor: pointer;
            border: none;
        }

        a {
            text-decoration: none;
        }

        .action-buttons {

            display: flex;
            gap: 10px;
        }
    </style>
</head>
<body>

<h2>Welcome to the Dream House, ${authenticatedUser.fullname}!</h2>
<h2>For Sale Apartment Details</h2>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Price</th>
        <th>Location</th>
        <th>Apartment</th>
        <th>Mobile</th>
        <%--<th>Country</th>--%>
        <!-- Add more columns as needed -->
        <%--<th>Actions</th>--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="seller" items="${sellers}">
        <tr>
            <td>${seller.id}</td>
            <td>${seller.name}</td>
            <td>${seller.email}</td>
            <td>${seller.price}</td>
            <td>${seller.location}</td>
            <td>${seller.appartment}</td>
            <td>${seller.mobile}</td>

            <!-- Add more columns as needed -->
           <%-- <td class="action-buttons">
                <a href="<c:url value='/students/${user.id}'/>"><button type="button">Details</button></a>
                <a href="<c:url value='/students/${user.id}/edit' />"><button type="button">Update</button></a>
                <a href="<c:url value='/students/${user.id}/delete' />"><button type="button">Delete</button></a>
            </td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br/>

<%--<a href="${pageContext.request.contextPath}/create"><button type="button">Add New Student</button></a>--%>
<a href="${pageContext.request.contextPath}/dashboard">
    <button type="button">Dashboard</button></a>

</body>
</html>
