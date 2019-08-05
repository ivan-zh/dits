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
    <title>Редактировать тему/тест</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<h4>Редактирование тестов</h4>
<form class="aligned-left" id="form" action="<c:url value="/tutor/topics_and_tests"/>" method="post">
    <select id="topics" name="selectedTopicId" onchange="updateTopic()">
        <option hidden selected value="0">Выберите тему</option>
        <c:forEach items="${topics}" var="x">
            <option value="${x.topicId}">${x.name}</option>
        </c:forEach>
    </select>
    <br>
    <div id="tests"></div>
    <br>
    <input disabled id="addButton" type="button" value="+" title="Добавить тест" onclick="addTest()"/>
    <input id="editData" name="editData" type="hidden" value="[]"/>
    <input type="submit" value="Сохранить" onclick="setData()"/>
    <input type="button" value="Назад" onclick="history.back();"/>
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
            document.getElementById("addButton").disabled = false;
            var topics = document.getElementById("topics");
            var tests = document.getElementById("tests");
            var topicId = topics[topics.selectedIndex].value;
            while (tests.firstChild) {
                tests.removeChild(tests.firstChild);
            }
            for (var i in testsList) {
                if (testsList[i].topicId == topicId) {
                    createTest(i);
                }
            }
        }

        function deleteTest(button) {
            var test = button.parentElement;
            var testIndex = test.getAttribute("testIndex");
            test.parentElement.removeChild(test);
            testsList[testIndex].action = "delete";
        }

        function renameTest(input) {
            var test = input.parentElement;
            var testIndex = test.getAttribute("testIndex");
            testsList[testIndex].name = input.value;
            if (testsList[testIndex].action == "none") {
                testsList[testIndex].action = "update";
            }
        }

        function setDescription(input) {
            var test = input.parentElement;
            var testIndex = test.getAttribute("testIndex");
            testsList[testIndex].description = input.value;
            if (testsList[testIndex].action == "none") {
                testsList[testIndex].action = "update";
            }
        }


        function createTest(testIndex) {
            var tests = document.getElementById("tests");
            var newTest = document.createElement("div");
            newTest.setAttribute("testIndex", testIndex);

            var nameInput = document.createElement("input");
            nameInput.type = "text";
            nameInput.value = testsList[testIndex].name;
            nameInput.placeholder = "Название теста";
            nameInput.setAttribute("oninput", "renameTest(this)");

            var descriptionInput = document.createElement("input");
            descriptionInput.type = "text";
            descriptionInput.value = testsList[testIndex].description;
            descriptionInput.placeholder = "Описание теста";
            descriptionInput.setAttribute("oninput", "setDescription(this)");

            var deleteButton = document.createElement("input");
            deleteButton.type = "button";
            deleteButton.value = "-";
            deleteButton.title = "Удалить тест";
            deleteButton.setAttribute("onclick", "deleteTest(this)");

            newTest.appendChild(nameInput);
            newTest.appendChild(descriptionInput)
            newTest.appendChild(deleteButton);

            tests.appendChild(newTest);
        }

        function addTest() {
            var topics = document.getElementById("topics");
            testsList[testsList.length] = {
                id: 0,
                topicId: topics[topics.selectedIndex].value,
                name: "",
                description: "",
                action: "create"
            };
            createTest(testsList.length - 1);
        }

        function setData() {
            var editData = document.getElementById("editData");
            editData.value = JSON.stringify(testsList);
        }

    </script>
</form>
</body>
</html>
