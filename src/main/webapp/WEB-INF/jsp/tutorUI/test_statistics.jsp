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
    <title>Статистика по тестам</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body>
<div class="aligned-left">
    <table>
        <tr>
            <th>Название теста</th>
            <th>Пройдено всего</th>
            <th>Процент правильных ответов</th>
        </tr>
        <c:forEach items="${stats}" var="s">
            <tr>
                <td>${s.name}</td>
                <td>${s.count}</td>
                <td class="percentage">${s.avg}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <input type="button" value="Назад" onclick="history.back()"/>
</div>
<script>
    var vals = document.getElementsByClassName("percentage")
    for (var x in vals) {
        var value = vals[x].innerText;
        vals[x].innerText = (Number(value) * 100).toFixed(1) + "%";
    }
</script>
</body>
</html>
