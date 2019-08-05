<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ссылки</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body>
<div class="aligned-left">
<table>
    <caption>Ссылки</caption>
    <tr>
        <th>linkId</th>
        <th>link</th>
        <th>id</th>
    </tr>
    <c:forEach var="t" items="${links}">
        <tr>
            <td>${t.linkId}</td>
            <td>${t.link}</td>
            <td>${t.id}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
