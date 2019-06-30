<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>
<p>Hello, ${greetname}!</p>
<hr>
Get user by id
<form method = "get" action = "/finduserbyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

Get all users
<form method = "get" action = "/allusers" >
    <input type="submit" value="Get all users" />
</form>
<hr>
Get topic by id
<form method = "get" action = "/findtopicbyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

Get all topics
<form method = "get" action = "/alltopics" >
    <input type="submit" value="Get all topics" />
</form>
<hr>
Get role by id
<form method = "get" action = "/findrolebyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

Get all roles
<form method = "get" action = "/allroles" >
    <input type="submit" value="Get all roles" />
</form>
<hr>
Get test by id
<form method = "get" action = "/findtestbyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

Get test by topic name
<form method = "get" action = "/findtestbytopicname" >
    <input name="topicname" type="text" />
    <input type="submit" value="Get" />
</form>

Get all tests
<form method = "get" action = "/alltests" >
    <input type="submit" value="Get all tests" />
</form>
<hr>
Get question by id
<form method = "get" action = "/findquestionbyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

Get all questions
<form method = "get" action = "/allquestions" >
    <input type="submit" value="Get all questions" />
</form>
<hr>
Get literature by id
<form method = "get" action = "/findliteraturebyid" >
    <input name="id" type="text" />
    <input type="submit" value="Get" />
</form>

Get all literatures
<form method = "get" action = "/allliteratures" >
    <input type="submit" value="Get all literatures" />
</form>

</body>
</html>
