<%--
  Created by IntelliJ IDEA.
  User: apurbadebnath
  Date: 31/12/23
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" %>
<%@ page isELIgnored="false" %>

<html>
<head>
  <title>Dashboard</title>
</head>
<body>
<h2>Welcome to the Dream House, ${authenticatedUser.fullname}!</h2>
<h2>Dashboard</h2>



<p></p>

<!-- Add your dashboard content here -->
<a href="${pageContext.request.contextPath}/dashboard/edit">Buyer Profile</a>
<br>
<a href="${pageContext.request.contextPath}/dashboard/seller">View Apartment To Buy</a>

<br><br>


<a href="${pageContext.request.contextPath}/logout">Logout</a>

</body>
</html>

