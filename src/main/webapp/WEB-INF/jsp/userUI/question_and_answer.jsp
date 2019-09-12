<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вопросы и ответы</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<form class="align-form"  name="answer"  action ="<c:url value="/user/select_topic_and_test_start"/>" method="get">
    <c:forEach items="${questions}" var="x">
        <label>
             <input type="text" value="${x.questionId}.${x.description}">
        </label>
    </c:forEach>
    <br>
    <br>
    <c:forEach items="${answers}" var="x">
        <label>
            <input type="text"  value="${x.description}">
            <input type="checkbox" title="${x.answerId}Правильный ответ">
        </label>
        <br>
    </c:forEach>
    <br>
     <input type="button" value="Следующий" onclick="setData()">
    <script>
        var questionsList = [
            <c:forEach items="${questions}" var="x">
            {
                id: ${x.questionId},
                testId: ${x.testId},
                description: "${x.description}",
                action: "none",
                answers: []
            },
            </c:forEach>
        ];
        var answersList = [
            <c:forEach items="${answers}" var="x">
            {
                id: ${x.answerId},
                questionId: ${x.questionId},
                description: "${x.description}",
                correct: ${x.correct},
                action: "none"
            },
            </c:forEach>
        ];

        function setData() {
            var selectData = document.getElementById("answerId");
            selectData.value = '<%= request.getAttribute("answerId")%>';
        }
    </script>
</form>
</body>
</html>
