<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Литература</title>
</head>
<body>

<table border="1">
    <caption>Литература</caption>
    <tr>
        <th>id</th>
        <th>description</th>
        <th>answerId</th>
    </tr>
    <c:forEach var="t" items="${literature}">
        <tr>
            <td>${t.id}</td>
            <td>${t.description}</td>
            <td>${t.answerId}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
