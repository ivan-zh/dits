<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topics</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body class="human">

<div class="aligned-left">
    <h4 align="center">Topics</h4>
    <table>
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
</div>
</body>
</html>
