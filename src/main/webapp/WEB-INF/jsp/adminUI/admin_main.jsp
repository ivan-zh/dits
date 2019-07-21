<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin UI main page</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<h4 align="center">Admin UI main page</h4>
<table border="0" cellspacing="2">
    <tbody>
    <tr>
        <td rowspan="4"><img width="50%" height="50%" src="<c:url value="/resources/images/human1.png"/>"></td>
        <td><a href="create_topic">Создать тест (topic)</a></td>
    </tr>
    <tr>
        <td><a href="create_user">Создать пользователя</a></td>
    </tr>
    <tr>
        <td><a href="statistics">Статистика</a></td>
    </tr>
    <tr>
        <td><a href="requests">Просмотр всей БД</a></td>
    </tr>
    </tbody>
</table>

</body>
</html>
