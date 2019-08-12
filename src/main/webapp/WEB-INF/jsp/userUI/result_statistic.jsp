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
        <th>Название вопроса</th>
        <th>Правильно</th>
        <th>Рекомендуемая литература</th>
        <th>Рекомендуемые ссылки на литературу</th>
    </tr>
    <c:forEach items="${statistic}" var="s">
        <tr>
            <td>${s.question}</td>
            <td>${s.correct}</td>
            <td>${s.description}</td>
            <td>${s.link}</td>
        </tr>
    </c:forEach>
</table>

<button onclick="history.back();">Назад</button>
</body>
</html>