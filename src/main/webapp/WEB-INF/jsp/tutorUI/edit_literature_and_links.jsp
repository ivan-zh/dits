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
<form class="aligned-left" id="form" action="<c:url value="/tutor/literature_and_links"/>" style="width: 40%"
      method="post">
    <label for="topics"></label>
    <select id="topics" onchange="updateTopic()">
        <option hidden selected value="0">Выберите тему</option>
        <c:forEach items="${topics}" var="x">
            <option value="${x.topicId}">${x.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="tests"></label>
    <select hidden id="tests" onchange="updateTest()">
        <option hidden selected value="0">Выберите тест</option>
        <c:forEach items="${tests}" var="x">
            <option hidden value="${x.testId}">${x.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="questions"></label>
    <select hidden id="questions" onchange="updateQuestion()">
        <option hidden selected value="0">Выберите вопрос</option>
        <c:forEach items="${questions}" var="x">
            <option hidden value="${x.questionId}">${x.description}</option>
        </c:forEach>
    </select>
    <br>
    <br>
    <div id="literature"></div>
    <br>
    <input hidden disabled class="char-button" id="addButton" type="button" value="+" title="Добавить вопрос"
           onclick="addLiterature()"/>
    <input id="data" name="editData" type="hidden" value="[]"/>
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

        var literatureList = [
            <c:forEach items="${literature}" var="x">
            {
                id: ${x.literatureId},
                questionId: ${x.questionId},
                description: "${x.description}",
                action: "none",
                links: []

            },
            </c:forEach>
        ];

        var linkList = [
            <c:forEach items="${links}" var="x">
            {
                id: ${x.linkId},
                literatureId: ${x.literatureId},
                linkValue: "${x.link}",
                action: "none"
            },
            </c:forEach>
        ];

        for (var i in linkList) {
            for (var j in literatureList) {
                if (linkList[i].literatureId === linkList[j].id) {
                    literatureList[j].links.push(linkList[i]);
                }
            }
        }

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
            var addButton = document.getElementById("addButton");
            addButton.hidden = false;
            addButton.disabled = true;

            var tests = document.getElementById("tests");
            var questions = document.getElementById("questions");
            var testId = tests[tests.selectedIndex].value;
            questions.hidden = false;
            //tests.options.selectedIndex = 0;
            for (var j = 1; j < questionsList.length; j++) {
                questions.options.remove(1);
            }
            for (var i = 0; i < questionsList.length; i++) {
                if (questionsList[i].testId == testId) {
                    var option = document.createElement("option");
                    option.value = questionsList[i].id;
                    option.text = questionsList[i].description;
                    questions.options.add(option);
                }
            }
        }

        function updateQuestion() {
            document.getElementById("addButton").disabled = false;
            var questions = document.getElementById("questions");
            var literature = document.getElementById("literature");
            var questionId = questions[questions.selectedIndex].value;
            while (literature.firstChild) {
                literature.removeChild(literature.firstChild);
            }
            for (var i in literatureList) {
                if (literatureList[i].questionId == questionId) {
                    createLiterature(i);
                }
            }
        }

        function updateLiterature(button) {
            var question = button.parentElement;
            var list = question.getElementsByTagName("OL")[0];
            list.hidden = !list.hidden;
        }

        function deleteLiterature(button) {
            var question = button.parentElement;
            var index = question.getAttribute("index");
            question.parentElement.removeChild(question);
            if (questionsList[index].action === "none") {
                questionsList[index].action = "delete";
            } else {
                questionsList.splice(index, 1);
            }
        }

        function renameLiterature(input) {
            var question = input.parentElement;
            var index = question.getAttribute("index");
            questionsList[index].description = input.value;
            if (questionsList[index].action === "none") {
                questionsList[index].action = "update";
            }
        }

        function renameLink(input) {
            var answer = input.parentElement;
            var linkIndex = answer.getAttribute("index");
            var question = answer.parentElement.parentElement;
            var index = question.getAttribute("index");
            var links = literatureList[index].links;
            links[linkIndex].linkValue = input.value;
            if (links[linkIndex].action === "none") {
                links[linkIndex].action = "update";
            }
        }

        function deleteLink(button) {
            var answer = button.parentElement;
            var linkIndex = answer.getAttribute("index");
            var question = answer.parentElement.parentElement;
            var index = question.getAttribute("index");
            var links = literatureList[index].links;
            answer.parentElement.removeChild(answer);
            if (links[linkIndex].action === "none") {
                links[linkIndex].action = "delete";
            } else {
                links.splice(linkIndex, 1);
            }
        }

        function createLink(index, linkIndex) {
            var links = literatureList[index].links;

            var item = document.createElement("li");
            item.className = "list-item-answer";
            item.setAttribute("index", linkIndex);

            var description = document.createElement("input");
            description.type = "text";
            description.value = links[linkIndex].linkValue;
            description.placeholder = "Ссылка на ресурс";
            description.className = "description";
            description.setAttribute("oninput", "renameLink(this)");

            var removeButton = document.createElement("input");
            removeButton.type = "button";
            removeButton.value = "-";
            removeButton.title = "Удалить ответ";
            removeButton.className = "char-button";
            removeButton.setAttribute("onclick", "deleteLink(this)");

            item.appendChild(description);
            item.appendChild(removeButton);

            return item;
        }

        function createLiterature(literatureIndex) {
            var literature = document.getElementById("literature");
            var newLiterature = document.createElement("div");
            newLiterature.setAttribute("index", literatureIndex);

            var nameInput = document.createElement("input");
            nameInput.type = "text";
            nameInput.value = literatureList[literatureIndex].description;
            nameInput.placeholder = "Описание вопроса";
            nameInput.className = "description";
            nameInput.setAttribute("oninput", "renameLiterature(this)");

            var editAnswersButton = document.createElement("input");
            editAnswersButton.type = "button";
            editAnswersButton.value = "⯆";
            editAnswersButton.title = "Редактировать ответы";
            editAnswersButton.className = "char-button";
            editAnswersButton.setAttribute("onclick", "updateLiterature(this)");


            var deleteButton = document.createElement("input");
            deleteButton.type = "button";
            deleteButton.value = "-";
            deleteButton.title = "Удалить вопрос";
            deleteButton.className = "char-button";
            deleteButton.setAttribute("onclick", "deleteLiterature(this)");

            var answers = document.createElement("ol");
            answers.hidden = true;
            for (var i in literatureList[literatureIndex].links) {
                answers.appendChild(createLink(literatureIndex, i));
            }
            var addAnswerButton = document.createElement("input");
            addAnswerButton.type = "button";
            addAnswerButton.value = "+";
            addAnswerButton.title = "Добавить ответ";
            addAnswerButton.className = "char-button";
            addAnswerButton.setAttribute("onclick", "addLink(this)");

            answers.appendChild(addAnswerButton);

            newLiterature.appendChild(nameInput);
            newLiterature.appendChild(editAnswersButton);
            newLiterature.appendChild(deleteButton);
            newLiterature.appendChild(answers);

            literature.appendChild(newLiterature);
        }

        function addLiterature() {
            var questions = document.getElementById("questions");
            literatureList[literatureList.length] = {
                id: 0,
                questionId: questions[questions.selectedIndex].value,
                description: "",
                action: "create",
                links: []
            };
            createLiterature(literatureList.length - 1);
        }

        function addLink(button) {
            var literature = button.parentElement.parentElement;
            var literatureIndex = literature.getAttribute("index");
            var linkList = literatureList[literatureIndex].links;
            linkList[linkList.length] = {
                id: 0,
                literatureId: 0,
                linkValue: "",
                action: "create"
            };
            var list = literature.getElementsByTagName("OL")[0];
            list.insertBefore(createLink(literatureIndex, linkList.length - 1), list.lastChild);
        }

        function setData() {
            document.getElementById("data").value = JSON.stringify(literatureList);
        }

    </script>
</form>
</body>
</html>
