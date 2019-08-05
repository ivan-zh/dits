<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личная статистика</title>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body>
<table>
    <tr>
        <th>ФИО</th>
        <th>Название теста</th>
        <th>Формулировка вопроса</th>
        <th>Пройдено всего</th>
        <th>Процент правильно пройденных вопросов</th>
    </tr>
    <c:forEach items="${statistic}" var="s">
        <tr>
            <td>${s.firstName} ${s.lastName}</td>
            <td>${s.name}</td>
            <td>${s.question}</td>
            <td>${s.count}</td>
            <td>${s.avg}</td>
        </tr>
    </c:forEach>
</table>

<button onclick="history.back();">Назад</button>
</body>
</html>
