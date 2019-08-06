<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roles</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body class="human">

<div class="aligned-left">
    <h4 align="center">Roles</h4>
    <table>
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
</div>
</body>
</html>
