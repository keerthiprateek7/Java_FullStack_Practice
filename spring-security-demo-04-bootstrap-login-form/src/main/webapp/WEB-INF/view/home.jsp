<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
  <h2>Good Afternoon -- Yoohoo Man -- No Soup</h2>
  <hr>
  
  Welcome to Home Page
  
  <!-- Add a logout button -->
  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
     <input type="submit" value="Logout" />
  </form:form>
</body>
</html>