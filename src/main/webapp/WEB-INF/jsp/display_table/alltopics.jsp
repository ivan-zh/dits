<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topics</title>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body>

<table border="1">
    <caption>Topics</caption>
    <tr>
        <th>topicId</th>
        <th>description</th>
        <th>name</th>
    </tr>
    <c:forEach var="t" items="${topics}">
        <tr>
            <td>${t.topicId}</td>
            <td>${t.description}</td>
            <td>${t.name}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
