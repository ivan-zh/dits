<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>

<h3>Get user by id</h3>
<form method = "get" action = "/findbyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

<br>

<h3>Get all users</h3>
<form method = "get" action = "/allusers" >
    <input type="submit" value="Get" />
</form>


</body>
</html>
