<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<form:form action = "" method = "POST" modelAttribute="user">
    First Name: <form:input type = "text" name = "name" path="name"/>
    <br />
    Email: <form:input type = "text" name = "email"  path="email"/>
    <input type = "submit" value = "Submit" />
</form:form>
</body>
</html>