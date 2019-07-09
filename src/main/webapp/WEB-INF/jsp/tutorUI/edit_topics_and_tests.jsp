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
</head>
<style>
    .select-editable {
        position: relative;
        background-color: white;
        border: solid grey 1px;
        width: 120px;
        height: 18px;
    }

    .select-editable select {
        position: absolute;
        top: 0px;
        left: 0px;
        font-size: 14px;
        border: none;
        width: 120px;
        margin: 0;
    }

    .select-editable input {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 100px;
        padding: 1px;
        font-size: 14px;
        border: none;
    }

    .select-editable select:focus, .select-editable input:focus {
        outline: none;
    }
</style>
<body>
<form action="topics_and_tests" method="post">
    <div class="select-editable">
        <select name="topic" onchange="updateTopic(this)">
            <option style="display: none" value="0"></option>
        </select>
        <input name="topicName" type="text" autocomplete="off" placeholder="Выберите тему"
               oninput="updateSelection(this.previousElementSibling)"/>
    </div>
    <div class="select-editable">
        <select name="test" onchange="updateTest(this)">
            <option style="display: none" value="0"></option>
        </select>
        <input name="testName" type="text" autocomplete="off" placeholder="Выберите тест"
               oninput="updateSelection(this.previousElementSibling)"/>
    </div>
    <div class="select-editable">
        <select name="question" onchange="updateQuestion(this)">
            <option style="display: none" value="0"></option>
        </select>
        <input name="questionName" type="text" autocomplete="off" placeholder="Выберите вопрос"
               oninput="updateSelection(this.previousElementSibling)"/>
    </div>
    <input type="submit" value="Сохранить"/>
    <script>
        var topics = [
            <c:forEach items="${topics}" var="x">
            {
                id: ${x.topicId},
                name: "${x.name}",
                description: "${x.description}"
            },
            </c:forEach>
        ];

        var tests = [
            <c:forEach items="${tests}" var="x">
            {
                id: ${x.testId},
                topicId: ${x.topicId},
                name: "${x.name}",
                description: "${x.description}"
            },
            </c:forEach>
        ];

        var questions = [
            <c:forEach items="${questions}" var="x">
            {
                id: ${x.questionId},
                testId: ${x.testId},
                description: "${x.description}"
            },
            </c:forEach>
        ];

        var selectTopics = document.getElementsByName("topic")[0];
        for (i in topics) {
            var x = topics[i];
            selectTopics.options[selectTopics.options.length] = new Option(x.name, x.id);
        }
        selectTopics.options.selectedIndex = 0;

        function updateTopic(topicsSelect) {
            topicsSelect.nextElementSibling.value = topicsSelect.options[topicsSelect.selectedIndex].text;

            var topicId = topicsSelect.options[topicsSelect.selectedIndex].value;
            var testsSelect = document.getElementsByName("test")[0];
            testsSelect.nextElementSibling.value = "";

            for (var i = testsSelect.options.length; i > 1; i--) {
                testsSelect.options.remove(1);
            }
            testsSelect.options.selectedIndex = 0;

            for (var idx in tests) {
                var x = tests[idx];
                if (x.topicId == topicId) {
                    testsSelect.options[testsSelect.options.length] = new Option(x.name, x.id);
                }
            }
        }

        function updateTest(testsSelect, saveText) {

            if (!saveText) {
                testsSelect.nextElementSibling.value = testsSelect.options[testsSelect.selectedIndex].text;
            }

            var testId = testsSelect.options[testsSelect.selectedIndex].value;
            var questionsSelect = document.getElementsByName("question")[0];
            questionsSelect.nextElementSibling.value = "";

            for (var i = questionsSelect.options.length; i > 1; i--) {
                questionsSelect.options.remove(1);
            }
            questionsSelect.options.selectedIndex = 0;

            for (var idx in questions) {
                var x = questions[idx];
                if (x.testId == testId) {
                    questionsSelect.options[questionsSelect.options.length] = new Option(x.description, x.id);
                }
            }
        }

        function updateQuestion(e) {
            e.nextElementSibling.value = e.options[e.selectedIndex].text
        }

        function updateSelection(e) {
            e.selectedIndex = 0;
            if (e.name == "topic") {
                updateTopic(e, true);
            } else if (e.name == "test") {
                updateTest(e, true);
            }
        }
    </script>
</form>
</body>
</html>
