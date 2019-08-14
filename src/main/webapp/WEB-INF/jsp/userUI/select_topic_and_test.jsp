<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбор темы и теста</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body class="human">
<form class="align-form" id="form" action="<c:url value="/user/question_and_answer"/>" method="post">
    <select id="topics" name="selectedTopicId">
    <option hidden selected value="0">Название темы</option>
    <c:forEach items="${topics}" var="x">
        <option value="${x.topicId}">${x.name}</option>
    </c:forEach>
</select>
<br>
    <select id="tests" name="selectedTestId">
        <option hidden selected value="0">Название теста</option>
        <c:forEach items="${tests}" var="x">
            <option value="${x.testId}">${x.name}</option>
        </c:forEach>
    </select>
<br>
    <br>
    <br>
    <br>
    <input type="submit" value="Пройти тестирование" >
</form>
</body>
</html>
