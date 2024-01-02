<%@ page contentType="text/html" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
 <script>
  function validateForm() {
   var name = document.forms["Seller"]["name"].value;
   var price = document.forms["Seller"]["price"].value;
   var email = document.forms["Seller"]["email"].value;
   var location = document.forms["Seller"]["location"].value;
   var appartment = document.forms["Seller"]["appartment"].value;
   var mobile = document.forms["Seller"]["mobile"].value;

   if (name == "" || price == "" || email == "" || location == "" || appartment == "" || mobile == "") {
    alert("Please fill in all the required fields");
    return false;
   }
   return true;
  }
 </script>
</head>
<body>
<h3>ADD Apartment For Sale</h3>
<h2>Welcome to the Dream House, ${authenticatedUser.fullname}!</h2>

<form:form method="post" action="${pageContext.request.contextPath}/storeSeller" modelAttribute="Seller" onsubmit="return validateForm()">

 <label>Name</label>
 <form:input path="name" id="name" required="true"/>
 <form:errors path="name"/>
 <br><br>

 <label>Price</label>
 <form:input type="text" path="price" id="price" required="true"/>

 <br><br>

 <label>Email</label>
 <form:input path="email" id="email" required="true"/>

 <br><br>

 <label>Location</label>
 <form:input path="location" id="location" required="true"/>

 <br><br>

 <label>Apartment</label>
 <form:input path="appartment" id="appartment" required="true"/>

 <br><br>

 <label>Mobile</label>
 <form:input path="mobile" id="mobile" required="true"/>

 <br><br>

 <input type="submit" value="Register" />
 <a href="${pageContext.request.contextPath}/login/showForm">ADD Another</a>
</form:form>

<%--<a href="${pageContext.request.contextPath}">Home</a>--%>
<%--<a href="${pageContext.request.contextPath}/login">Dashboard</a>--%>
<br>
<a href="${pageContext.request.contextPath}/dashboard">
 <button type="button">Dashboard</button></a>

</body>
</html>
