<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать тест (topic)</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<h4>Создать тест (topic)</h4>
<form action="<c:url value="/add_topic_to_db"/>" method="post">
    <table class="centered">
        <tr>
            <td>
                Описание
            </td>
            <td>
                <input type="text" name="description" id="description">
            </td>
        </tr>
        <tr>
            <td>
                Имя
            </td>
            <td>
                <input type="text" name="name" id="name">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Add new topic">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
