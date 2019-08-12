<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.08.2019
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question and answers</title>
</head>
<body>
<form class="align-form" id="form">
    <%--<c:forEach items="${questions}" var="x">--%>
    <%--<div id="questions" ${x.questionId} >${x.name}</div>--%>
    <%--<br>--%>
    <%--<br>--%>

            <%--<option value="${x.questionId}">${x.name}</option>--%>

    <%--<br>--%>
    <%--<br>--%>
    <%--<br>--%>
    <%--<br>--%>
    <%--</c:forEach>--%>
        <input type="button" value="Следующий" action="<c:url value="user/question_and_answer"/>" method="post">
</form>

</body>
</html>
