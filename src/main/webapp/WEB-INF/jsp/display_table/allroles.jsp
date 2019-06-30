<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roles</title>
</head>
<body>

<table border="1">
    <caption>Roles</caption>
    <tr>
        <th>roleId</th>
        <th>admin</th>
        <th>tutor</th>
        <th>user</th>
    </tr>
    <c:forEach var="t" items="${roles}">
        <tr>
            <td>${t.roleId}</td>
            <td>${t.admin}</td>
            <td>${t.tutor}</td>
            <td>${t.user}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
