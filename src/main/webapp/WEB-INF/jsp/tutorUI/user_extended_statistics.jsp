<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artiom
  Date: 28.07.2019
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select onselect="selectUser(this)">
    <c:forEach var="x" items="${users}">
        <option value="${x.userid}">${x.firstName} ${x.lastName}</option>
    </c:forEach>
</select>
<script>
    function selectUser(select) {
        var option = select.options[select.selectedIndex];
        var userId = option.value;
    }
</script>
</body>
</html>
