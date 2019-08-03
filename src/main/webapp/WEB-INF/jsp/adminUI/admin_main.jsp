<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin UI main page</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<h4 align="center">Admin UI main page</h4>

<table class="centered">
    <tbody>
    <tr>
        <td><a href="<c:url value="/admin/create_topic"/>">Создать тест (topic)</a></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/admin/create_user"/>">Создать пользователя</a></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/tutor/statistics"/>">Статистика</a></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/admin/requests"/>">Просмотр всей БД</a></td>
    </tr>
    </tbody>
</table>

</body>
</html>
