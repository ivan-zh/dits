<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tests</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
</head>
<body class="human">

<div class="aligned-left">
    <h4 align="center">Tests</h4>
    <table>
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
</div>
</body>
</html>
