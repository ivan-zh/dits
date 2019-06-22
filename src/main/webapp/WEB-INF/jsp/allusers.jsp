<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>userId</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>login</th>
        <th>password</th>
        <th>roleId</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.userId}</td>
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
            <td>${u.login}</td>
            <td>${u.password}</td>
            <td>${u.roleId}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>