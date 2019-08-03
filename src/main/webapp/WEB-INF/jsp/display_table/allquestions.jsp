<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body>
<table class="centered smaller_font">
    <caption>Questions</caption>
    <tr>
        <th>questionId</th>
        <th>description</th>
        <th>testId</th>
    </tr>
    <c:forEach var="t" items="${questions}">
        <tr>
            <td>${t.questionId}</td>
            <td>${t.description}</td>
            <td>${t.testId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
