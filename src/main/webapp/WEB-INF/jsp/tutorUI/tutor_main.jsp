<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artiom
  Date: 28.06.2019
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tutor Main</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<div class="aligned-left">
    <a href="tutor/topics_and_tests">Редактировать тему/тест</a><br>
    <a href="tutor/questions_and_answers">Редактировать вопросы/ответы</a><br>
    <a href="tutor/literature_and_links/">Редактировать литературу</a><br>
    <a href="tutor/statistics">Статистика</a><br>
</div>
</body>
</html>
