<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form" %>

<DOCTYPE html>
<html>
<head>
<title> Hello World-Input Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
   First Name: <form:input path="firstName" />
   <br><br>
   Last Name: <form:input path="lastName" />
   <br><br>
   Country:
   <form:select path="country">
      <form:options items="${student.countryOptions}" />
   </form:select>
   <br><br>
   Favorite Language:
   Java<form:radiobutton path="favoriteLanguage" value="Java" />
   C#<form:radiobutton path="favoriteLanguage" value="C#" />
   PHP<form:radiobutton path="favoriteLanguage" value="PHP" />
   Ruby<form:radiobutton path="favoriteLanguage" value="Ruby" />
   <br><br>
   Operating Systems:
   Linux<form:checkbox path="operatingSystem" value="Linux" />
   Windows<form:checkbox path="operatingSystem" value="Windows" />
   Mac<form:checkbox path="operatingSystem" value="Mac OS" />
   <br><br>
   
   <input type="submit" value="Submit" />
</form:form>
</body>
</html>