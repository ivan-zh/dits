<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artiom
  Date: 29.06.2019
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Статистика по пользователям</title>
</head>
<body>
<table>
    <tr>
        <th>Имя</th>
        <th>Название теста</th>
        <th>Пройдено всего</th>
        <th>Процент правильных ответов</th>
    </tr>
    <c:forEach items="${stats}" var="s">
        <tr>
            <td>${s.firstName} ${s.lastName}</td>
            <td>${s.name}</td>
            <td>${s.count}</td>
            <td>${s.avg}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
