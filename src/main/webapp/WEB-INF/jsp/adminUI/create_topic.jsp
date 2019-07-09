<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать тест (topic)</title>
</head>
<body>
<h4>Создать тест (topic)</h4>
<hr>
<form action="add_topic_to_db" method="post">
    <label for="description">Description</label>
    <input type="text" name="description" id="description">
    <br>
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <br>
    <input type="submit" value="Add new topic">

</form>

</body>
</html>
