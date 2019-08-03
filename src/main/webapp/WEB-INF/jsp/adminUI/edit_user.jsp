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

<form action="<c:url value="/edit_user"/>" method="post">
    <input type="hidden" name="userId" value="${user.userId}">
    <table class="centered">
        <tr>
            <td>
                <select name="roleName">
                    <c:forEach var="roleName" items="${rolesNames}">
                        <option>${roleName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="firstName" id="firstName" value="${user.firstName}" placeholder="firstName">
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="lastName" id="lastName" value="${user.lastName}" placeholder="lastName">
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="login" id="login" value="${user.login}" placeholder="login">
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="password" id="password" value="" placeholder="password">
            </td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="Edit user">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
