<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>
<p>Hello, ${greetname}!</p>

Get user by id
<form method = "get" action = "/finduserbyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

Get all users
<form method = "get" action = "/allusers" >
    <input type="submit" value="Get all users" />
</form>

Get topic by id
<form method = "get" action = "/findtopicbyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

Get all topics
<form method = "get" action = "/alltopics" >
    <input type="submit" value="Get all topics" />
</form>

Get role by id
<form method = "get" action = "/findrolebyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

Get all roles
<form method = "get" action = "/allroles" >
    <input type="submit" value="Get all roles" />
</form>
</body>
</html>
