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

<form action="<c:url value="/add_user_to_db"/>" method="post">
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
                <input type="text" name="firstName" id="firstName" placeholder="firstName">
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="lastName" id="lastName" placeholder="lastName">
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="login" id="login" placeholder="login">
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="password" id="password" placeholder="password">
            </td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="Add new user">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
