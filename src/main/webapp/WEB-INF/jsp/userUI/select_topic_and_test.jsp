<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбор темы и теста</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<form class="align-form" name="testId"  action ="<c:url value="/user/select_topic_and_test_start"/>" method="get">
    <label for="topics"></label>
    <select id="topics" onchange="updateTopic()">
        <option hidden selected value="0">Выберите тему</option>
        <c:forEach items="${topics}" var="x">
            <option value="${x.topicId}">${x.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="tests"></label>
    <select hidden id="tests" name="testId">
        <option hidden selected value="0">Выберите тест</option>
        <c:forEach items="${tests}" var="x">
            <option hidden value="${x.testId}">${x.name}</option>
        </c:forEach>
    </select>
    <br>
    <br>
    <br>
    <input id="data" name="selectData" type="hidden" value="[]"/>
<%--     <input type="button" name="start" value="Пройти тестирование">--%>
    <button name="start" onclick="setData()"  >Пройти тестирование</button>
    <script>
        var topicsList = [
            <c:forEach items="${topics}" var="x">
            {
                id: ${x.topicId},
                name: "${x.name}",
                description: "${x.description}"
            },
            </c:forEach>
        ];
        var testsList = [
            <c:forEach items="${tests}" var="x">
            {
                id: ${x.testId},
                topicId: ${x.topicId},
                name: "${x.name}",
                description: "${x.description}",
                action: "none"
            },
            </c:forEach>
        ];
        function updateTopic() {
            var topics = document.getElementById("topics");
            var tests = document.getElementById("tests");
            var topicId = topics[topics.selectedIndex].value;
            tests.hidden = false;

            for (var j = 1; j < testsList.length; j++) {
                tests.options.remove(1);
            }
            for (var i = 0; i < testsList.length; i++) {
                if (testsList[i].topicId == topicId) {
                    var option = document.createElement("option");
                    option.value = testsList[i].id;
                    option.text = testsList[i].name;
                    tests.options.add(option);
                }
            }
        }
        function setData() {
            var selectData = document.getElementById("testId");
            selectData.value = '<%= request.getAttribute("testId")%>';
        }
    </script>
</form>

</body>
</html>
