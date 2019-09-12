<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>User main page</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
            <table class="center">
                <tr>
                    <td>
                        <a href="<c:url value="/user/select_topic_and_test"/>">Выбор темы и теста </a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="<c:url value="/user/personal_statistic"/>">Личная статистика</a>
                    </td>
                </tr>
                <%--<tr>--%>
                    <%--<td>--%>
                <%--<%@ include file = "../logout_form.jsp"%>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            </table>
</body>
</html>
