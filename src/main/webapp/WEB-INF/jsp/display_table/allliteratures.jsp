<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Литература</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body>
<div class="aligned-left">
<table>
    <caption>Литература</caption>
    <tr>
        <th>id</th>
        <th>description</th>
        <th>questionId</th>
    </tr>
    <c:forEach var="t" items="${literature}">
        <tr>
            <td>${t.id}</td>
            <td>${t.description}</td>
            <td>${t.questionId}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
