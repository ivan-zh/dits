<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Literature</title>
</head>
<body>

<table border="1">
    <caption>Literature</caption>
    <tr>
        <th>literatureId</th>
        <th>description</th>
        <th>questionId</th>
    </tr>
    <c:forEach var="t" items="${literature}">
        <tr>
            <td>${t.literatureId}</td>
            <td>${t.description}</td>
            <td>${t.questionId}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
