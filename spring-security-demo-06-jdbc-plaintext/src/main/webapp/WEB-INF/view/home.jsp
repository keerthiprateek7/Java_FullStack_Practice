<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
  <h2>Good Afternoon -- Yoohoo Man -- No Soup</h2>
  <hr>
  <!-- Display user name and role -->
  <p>
     User:<sec:authentication property="principal.username" />
     <br><br>
     Role(s):<sec:authentication property="principal.authorities" />
  </p>
  
  <hr>
     <sec:authorize access="hasRole('MANAGER')">
     <!-- Add link to point to leaders this is for the managers -->
     <p><a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
     (Only for Manager Peeps)</p>
     </sec:authorize>
     
     <sec:authorize access="hasRole('ADMIN')">
     <!-- Add link to point to admins this is for the systems -->
     <p><a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
     (Only for Admin Peeps)</p>
     </sec:authorize>
     
  <hr>
  Welcome to Home Page
  
  <!-- Add a logout button -->
  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
     <input type="submit" value="Logout" />
  </form:form>
</body>
</html>