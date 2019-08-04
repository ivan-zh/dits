<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testing system</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>

<h4 align="center">Welcome to Dev Inc Testing system !</h4>

<table class="centered">
    <tbody>
    <tr>
        <td>
            <form name="login" action="login" method="post">
                <table>
                    <tr style="width: 50%">
                        <td><b>Login:</b></td>
                        <td><input name="loginname" type="text"></td>
                    </tr>
                    <tr>
                        <td><b>Pass:</b></td>
                        <td><input name="password" value="" type="password"></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;"><input type="submit" value="Войти"/></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
