<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать пользователя</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<h4 align="center">Создать пользователя</h4>
<hr>
<form action="<c:url value="/add_user_to_db"/>" method="post">
    <select name="roleName">
        <c:forEach var="roleName" items="${rolesNames}">
            <option>${roleName}</option>
        </c:forEach>
    </select>
    <br>
    <label for="firstName">firstName</label>
    <input type="text" name="firstName" id="firstName">
    <br>
    <label for="lastName">lastName</label>
    <input type="text" name="lastName" id="lastName">
    <br>
    <label for="login">login</label>
    <input type="text" name="login" id="login">
    <br>
    <label for="password">password</label>
    <input type="text" name="password" id="password">
    <br>
    <input type="submit" value="Add new user">

</form>
</body>
</html>
