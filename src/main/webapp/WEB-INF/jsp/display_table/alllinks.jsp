<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ссылки</title>
</head>
<body>

<table border="1">
    <caption>Ссылки</caption>
    <tr>
        <th>linkId</th>
        <th>link</th>
        <th>literatureId</th>
    </tr>
    <c:forEach var="t" items="${links}">
        <tr>
            <td>${t.linkId}</td>
            <td>${t.link}</td>
            <td>${t.literatureId}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>