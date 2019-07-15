<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artiom
  Date: 28.06.2019
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать вопросы/ответы</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/css/tutor.css"/>" type="text/css"/>
</head>
<body>
<form class="aligned-left" id="form" action="questions_and_answers" method="post">
    <label for="topics"></label>
    <select id="topics" name="selectedTopicId" onchange="updateTopic()">
        <option hidden selected value="0">Выберите тему</option>
        <c:forEach items="${topics}" var="x">
            <option value="${x.topicId}">${x.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="tests"></label>
    <select hidden id="tests" name="selectedTopicId" onchange="updateTest()">
        <option hidden selected value="0">Выберите тест</option>
        <c:forEach items="${tests}" var="x">
            <option hidden value="${x.testId}">${x.name}</option>
        </c:forEach>
    </select>
    <br>
    <div id="questions"></div>
    <br>
    <input hidden disabled class="char-button" id="addButton" type="button" value="+" title="Добавить вопрос"
           onclick="addQuestion()"/>
    <input id="editData" name="editData" type="hidden" value="[]"/>
    <input type="submit" value="Сохранить" onclick="setData()"/>
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
                description: "${x.description}"
            },
            </c:forEach>
        ];

        var questionsList = [
            <c:forEach items="${questions}" var="x">
            {
                id: ${x.questionId},
                testId: ${x.testId},
                description: "${x.description}",
                action: "none"
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

        function updateTopic() {
            var addButton = document.getElementById("addButton");
            addButton.hidden = false;
            addButton.disabled = true;

            var topics = document.getElementById("topics");
            var tests = document.getElementById("tests");
            var topicId = topics[topics.selectedIndex].value;
            tests.hidden = false;
            //tests.options.selectedIndex = 0;
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

        function updateTest() {
            document.getElementById("addButton").disabled = false;
            var tests = document.getElementById("tests");
            var questions = document.getElementById("questions");
            var testId = tests[tests.selectedIndex].value;
            while (questions.firstChild) {
                questions.removeChild(questions.firstChild);
            }
            for (var i in questionsList) {
                if (questionsList[i].testId == testId) {
                    createQuestion(i);
                }
            }
        }

        function updateQuestion(button) {
            var question = button.parentElement;
        }

        function deleteQuestion(button) {
            var test = button.parentElement;
            var testIndex = test.getAttribute("testIndex");
            test.parentElement.removeChild(test);
            testsList[testIndex].action = "delete";
        }

        function renameQuestion(input) {
            var question = input.parentElement;
            var questionIndex = question.getAttribute("testIndex");
            questionsList[questionIndex].description = input.value;
            if (questionsList[questionIndex].action == "none") {
                questionsList[questionIndex].action = "update";
            }
        }

        function createQuestion(questionIndex) {
            var questions = document.getElementById("questions");
            var newQuestion = document.createElement("div");
            newQuestion.setAttribute("testIndex", questionIndex);

            var nameInput = document.createElement("input");
            nameInput.type = "text";
            nameInput.value = questionsList[questionIndex].description;
            nameInput.placeholder = "Описание вопроса";
            nameInput.className = "description";
            nameInput.setAttribute("oninput", "renameQuestion(this)");

            var editAnswersButton = document.createElement("input");
            editAnswersButton.type = "button";
            editAnswersButton.value = "⯆";
            editAnswersButton.title = "Редактировать ответы";
            editAnswersButton.className = "char-button";
            editAnswersButton.setAttribute("onclick", "updateQuestion(this)");


            var deleteButton = document.createElement("input");
            deleteButton.type = "button";
            deleteButton.value = "-";
            deleteButton.title = "Удалить вопрос";
            deleteButton.className = "char-button";
            deleteButton.setAttribute("onclick", "deleteQuestion(this)");

            var answers = document.createElement("ol");
            for (var i in answersList) {
                if (answersList[i].questionId === questionsList[questionIndex].id) {
                    var item = document.createElement("li");
                    item.className = "list-item-answer";

                    var description = document.createElement("input");
                    description.type = "text";
                    description.value = answersList[i].description;
                    description.placeholder = "Описание ответа";
                    description.className = "description";

                    var correct = document.createElement("input");
                    correct.type = "checkbox";
                    correct.checked = answersList[i].correct;
                    correct.title = "Правильный ответ";

                    var removeButton = document.createElement("input");
                    removeButton.type = "button";
                    removeButton.value = "-";
                    removeButton.title = "Удалить ответ";
                    removeButton.className = "char-button";
                    removeButton.setAttribute("onclick", "deleteAnswer(this)");

                    item.appendChild(description);
                    item.appendChild(correct);
                    item.appendChild(removeButton);

                    answers.appendChild(item);
                }
            }
            var addAnswerButton = document.createElement("input");
            addAnswerButton.type = "button";
            addAnswerButton.value = "+";
            addAnswerButton.title = "Добавить ответ";
            addAnswerButton.className = "char-button";
            addAnswerButton.setAttribute("onclick", "addAnswer(this)");

            answers.appendChild(addAnswerButton);

            newQuestion.appendChild(nameInput);
            newQuestion.appendChild(editAnswersButton);
            newQuestion.appendChild(deleteButton);
            newQuestion.appendChild(answers);

            questions.appendChild(newQuestion);
        }

        function addQuestion() {
            var tests = document.getElementById("tests");
            questionsList[questionsList.length] = {
                id: 0,
                questionId: tests[tests.selectedIndex].value,
                description: "",
                action: "create"
            };
            createQuestion(questionsList.length - 1);
        }

        function setData() {
            var editData = document.getElementById("editData");
            editData.value = JSON.stringify(questionsList);
        }

    </script>
</form>
</body>
</html>
