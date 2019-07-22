<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artiom
  Date: 28.06.2019
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<div class="aligned-left">
    <a href="statistics/test">Статистика по тестам</a><br>
    <a href="statistics/question">Статистика по вопросам</a><br>
    <a href="statistics/user">Статистика по пользователям</a><br>
    <input type="button" value="Назад" onclick="history.back()"/>
</div>
</body>
</html>
