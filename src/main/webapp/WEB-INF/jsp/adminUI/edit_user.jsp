<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать пользователя</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<h4 align="center">Редактировать пользователя</h4>
<hr>
<form action="<c:url value="/edit_user"/>" method="post">
    <select name="roleName">
        <c:forEach var="roleName" items="${rolesNames}">
            <option>${roleName}</option>
        </c:forEach>
    </select>
    <br>
    <input type="hidden" name="userId" value="${user.userId}">

    <label for="firstName">firstName</label>
    <input type="text" name="firstName" id="firstName" value="${user.firstName}">
    <br>
    <label for="lastName">lastName</label>
    <input type="text" name="lastName" id="lastName" value="${user.lastName}">
    <br>
    <label for="login">login</label>
    <input type="text" name="login" id="login" value="${user.login}">
    <br>
    <label for="password">password</label>
    <input type="text" name="password" id="password" value="">
    <br>
    <input type="submit" value="Edit user">

</form>
</body>
</html>
