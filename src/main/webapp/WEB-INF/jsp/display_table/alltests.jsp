<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tests</title>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body>

<table border="1">
    <caption>Tests</caption>
    <tr>
        <th>testId</th>
        <th>name</th>
        <th>description</th>
        <th>topicId</th>
    </tr>
    <c:forEach var="t" items="${tests}">
        <tr>
            <td>${t.testId}</td>
            <td>${t.name}</td>
            <td>${t.description}</td>
            <td>${t.topicId}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
