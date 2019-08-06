<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body class="human">

<div class="aligned-left">
    <h4 align="center">Users</h4>
    <table class="centered">
        <tr>
            <th>userId</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>login</th>
            <th>password</th>
            <th>roleId</th>
            <th>Action</th>
        </tr>
        <c:forEach var="u" items="${users}">
            <tr>
                <td>${u.userId}</td>
                <td>${u.firstName}</td>
                <td>${u.lastName}</td>
                <td>${u.login}</td>
                <td>${u.password}</td>
                <td>${u.roleId}</td>
                <td><a href="/edit_user/${u.userId}">Редактировать</a> <a href="/delete_user/${u.userId}">Удалить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
